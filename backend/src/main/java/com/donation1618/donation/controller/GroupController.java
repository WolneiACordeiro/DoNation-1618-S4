package com.donation1618.donation.controller;

import com.donation1618.donation.domain.dto.UserDTO;
import com.donation1618.donation.domain.entities.Group;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.GroupService;
import com.donation1618.donation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    private final UserRepository userRepository;

    @Autowired
    public GroupController(GroupService groupService, UserService userService, UserRepository userRepository) {
        this.groupService = groupService;
        this.userRepository = userRepository;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<Group> createGroup(@RequestBody Group group, @PathVariable String userId) {
        Group groupCreated = groupService.createGroup(group, userId);
        return new ResponseEntity<>(groupCreated, HttpStatus.CREATED);
    }
}
