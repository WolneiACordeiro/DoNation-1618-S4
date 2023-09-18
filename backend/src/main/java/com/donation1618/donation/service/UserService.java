package com.donation1618.donation.service;

import com.donation1618.donation.domain.dto.UserDTO;
import com.donation1618.donation.domain.dto.UserUpdateDTO;
import com.donation1618.donation.domain.entities.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(String userId, UserUpdateDTO userUpdateDTO);
    public void deleteUser(String userId);
    List<UserDTO> getAllUsers();
}
