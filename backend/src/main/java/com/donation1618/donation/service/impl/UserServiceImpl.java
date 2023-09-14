package com.donation1618.donation.service.impl;

import com.donation1618.donation.domain.dto.UserDTO;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.UserService;
import com.donation1618.donation.service.impl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.dtoToEntity(userDTO);
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
