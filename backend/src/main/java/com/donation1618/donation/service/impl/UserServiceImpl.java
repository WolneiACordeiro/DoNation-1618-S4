package com.donation1618.donation.service.impl;

import com.donation1618.donation.domain.dto.UserDTO;
import com.donation1618.donation.domain.dto.UserUpdateDTO;
import com.donation1618.donation.domain.entities.Role;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.domain.entities.enums.RoleEnum;
import com.donation1618.donation.repository.RoleRepository;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.UserService;
import com.donation1618.donation.service.exceptions.EmailAlreadyExistsException;
import com.donation1618.donation.service.exceptions.ResourceNotFoundException;
import com.donation1618.donation.service.impl.mapper.UserMapper;
import com.donation1618.donation.utils.ExternalIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.dtoToEntity(userDTO);
        Role role = roleRepository.findByName(RoleEnum.ROLE_USER.name());
        if (role == null) {
            role = new Role(ExternalIdGenerator.generateUniqueId(),RoleEnum.ROLE_USER);
            role = roleRepository.save(role);
        }
        user.setRoles(Collections.singletonList(role));
        User savedUser = userRepository.save(user);
        return userMapper.entityToDto(savedUser);
    }
    @Override
    @Transactional
    public UserDTO updateUser(String userId, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId));
        String newEmail = userUpdateDTO.getEmail();
        String currentEmail = user.getEmail();
        if (!newEmail.equals(currentEmail)) {
            Boolean existingUser = userRepository.existsByEmail(newEmail);
            if (existingUser != false) {
                throw new EmailAlreadyExistsException("O email '" + newEmail + "' já está em uso por outro usuário.");
            }
        }
        user.setUsername(userUpdateDTO.getUsername());
        user.setEmail(newEmail);
        user.setPassword(userUpdateDTO.getPassword());
        if (userUpdateDTO.getRoles() != null && !userUpdateDTO.getRoles().isEmpty()) {
            List<Role> updatedRoles = new ArrayList<>();
            for (Role roleDTO : userUpdateDTO.getRoles()) {
                RoleEnum roleName = roleDTO.getName();
                RoleEnum roleEnum = roleName;
                Role role = roleRepository.findByName(roleEnum.name());
                if (role == null) {
                    role = new Role(ExternalIdGenerator.generateUniqueId(),roleEnum);
                    role = roleRepository.save(role);
                }
                updatedRoles.add(role);
            }
            user.setRoles(updatedRoles);
        }
        User updatedUser = userRepository.save(user);
        return userMapper.entityWithRolesToDto(updatedUser);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::entityWithRolesToDto)
                .collect(Collectors.toList());
    }
}
