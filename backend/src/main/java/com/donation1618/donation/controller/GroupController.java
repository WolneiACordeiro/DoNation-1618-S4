package com.donation1618.donation.controller;

import com.donation1618.donation.domain.dto.GroupDTO;
import com.donation1618.donation.domain.dto.UserRelationsDTO;
import com.donation1618.donation.domain.entities.RelationshipGroupWantJoin;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.domain.entities.enums.JoinGroupStatusEnum;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.GroupService;
import com.donation1618.donation.service.impl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository relationJoinRepository;


    public void RelationshipGroupController(UserRepository relationJoinRepository) {
        this.relationJoinRepository = relationJoinRepository;
    }

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<GroupDTO> createGroup(@RequestBody GroupDTO groupDTO, @PathVariable UUID userId) {
        GroupDTO groupCreated = groupService.createGroup(groupDTO, userId);
        return new ResponseEntity<>(groupCreated, HttpStatus.CREATED);
    }

    @PostMapping("/join/{groupId}/{userId}")
    public ResponseEntity<RelationshipGroupWantJoin> joinGroup(@PathVariable UUID groupId, @PathVariable UUID userId) {
        RelationshipGroupWantJoin groupCreated = groupService.joinGroup(groupId, userId);
        return new ResponseEntity<>(groupCreated, HttpStatus.CREATED);
    }

    @PostMapping("/accept/{groupId}/{userId}")
    public ResponseEntity<UserRelationsDTO> acceptGroup(@PathVariable UUID groupId, @PathVariable UUID userId) {
        UserRelationsDTO joinAccepted = groupService.acceptGroup(groupId, userId);
        return new ResponseEntity<>(joinAccepted, HttpStatus.ACCEPTED);
    }

}
