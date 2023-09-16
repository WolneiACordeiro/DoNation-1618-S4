package com.donation1618.donation.controller;

import com.donation1618.donation.domain.dto.UserDTO;
import com.donation1618.donation.domain.dto.UserUpdateDTO;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUserDTO = service.createUser(userDTO);
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId,@Valid @RequestBody UserUpdateDTO update) {
        UserDTO updatedUser = service.updateUser(userId, update);
        return ResponseEntity.ok(updatedUser);
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = service.getAllUsers();
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        service.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
