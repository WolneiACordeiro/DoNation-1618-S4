package com.donation1618.donation.controller;

import com.donation1618.donation.domain.entities.Group;
import com.donation1618.donation.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<Group> createGroup(@RequestBody Group group, @PathVariable UUID userId) {
        Group groupCreated = groupService.createGroup(group, userId);
        return new ResponseEntity<>(groupCreated, HttpStatus.CREATED);
    }
}
