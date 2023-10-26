package com.donation1618.donation.controller;

import com.donation1618.donation.domain.dto.GroupDTO;
import com.donation1618.donation.domain.entities.RelationshipGroupWantJoin;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

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
    public ResponseEntity<RelationshipGroupWantJoin> acceptGroup(@PathVariable UUID groupId, @PathVariable UUID userId) {
        RelationshipGroupWantJoin groupCreated = groupService.acceptGroup(groupId, userId);
        return new ResponseEntity<>(groupCreated, HttpStatus.OK);
    }

    @GetMapping("/{relationId}")
    public List<User> getRelationshipByRelationId(@PathVariable String relationId) {
        return relationJoinRepository.findAll();
    }
}
