package com.donation1618.donation.service;

import com.donation1618.donation.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUser(Long userId);
    public List<User> getAllUsers();
    public Optional<User> getUserById(Long userId);
}
