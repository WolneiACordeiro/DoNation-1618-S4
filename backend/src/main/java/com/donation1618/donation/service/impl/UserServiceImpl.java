package com.donation1618.donation.service.impl;

import com.donation1618.donation.entities.User;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    @Transactional
    public User createUser(User user) {
        return repository.save(user);
    }
    @Override
    @Transactional
    public User updateUser(User user) {
        return repository.save(user);
    }
    @Override
    @Transactional
    public void deleteUser(Long userId) {
        repository.deleteById(userId);
    }
    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return repository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserById(Long userId) {
        return repository.findById(userId);
    }
}
