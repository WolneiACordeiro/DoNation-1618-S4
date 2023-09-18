package com.donation1618.donation.service.impl.mapper;

import com.donation1618.donation.domain.dto.UserDTO;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.utils.ExternalIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {
    public UserDTO entityToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
    public User dtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(ExternalIdGenerator.generateUniqueId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}