package com.donation1618.donation.service.impl;

import com.donation1618.donation.domain.dto.UserDTO;
import com.donation1618.donation.domain.entities.Role;
import com.donation1618.donation.domain.entities.Roles;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.repository.RoleRepository;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.UserService;
import com.donation1618.donation.service.impl.mapper.UserMapper;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.dtoToEntity(userDTO);
        Role role = roleRepository.findByName(Roles.ROLE_USER.name());
        if (role == null) {
            role = new Role(Roles.ROLE_USER);
            role = roleRepository.save(role);
        }
        user.setRoles(Collections.singletonList(role));
        User savedUser = repository.save(user);
        return userMapper.entityToDto(savedUser);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteUser(Long userId) {
        repository.deleteById(userId);
    }
    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(userMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
