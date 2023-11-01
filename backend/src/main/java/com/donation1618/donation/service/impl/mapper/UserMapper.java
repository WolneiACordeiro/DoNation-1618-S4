package com.donation1618.donation.service.impl.mapper;

import com.donation1618.donation.domain.dto.UserDTO;
import com.donation1618.donation.domain.dto.UserRelationsDTO;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.utils.ExternalIdGenerator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserMapper {
    public UserDTO entityToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
    public UserDTO entityWithRolesToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(user.getRoles());
        userDTO.setGroupWantJoins(user.getGroupWantJoins());
        userDTO.setGroupMemberships(user.getGroupMemberships());
        return userDTO;
    }
    public UserRelationsDTO entityOnlyRelationsDto(User user) {
        UserRelationsDTO userDTO = new UserRelationsDTO();
        userDTO.setId(user.getId());
        userDTO.setGroupWantJoins(user.getGroupWantJoins());
        return userDTO;
    }
    public User dtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
