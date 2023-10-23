package com.donation1618.donation.service;

import com.donation1618.donation.domain.dto.UserDTO;
import com.donation1618.donation.domain.dto.UserUpdateDTO;
import com.donation1618.donation.domain.entities.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UUID userId, UserUpdateDTO userUpdateDTO);
    public void deleteUser(UUID userId);
    List<UserDTO> getAllUsers();
}
