package com.donation1618.donation.controller;

import com.donation1618.donation.domain.dto.GroupDTO;
import com.donation1618.donation.domain.dto.UserRelationsDTO;
import com.donation1618.donation.domain.entities.relations.RelationshipGroupWantJoin;
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
    private final GroupService service;

    @Autowired
    public GroupController(GroupService groupService) {
        this.service = groupService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<GroupDTO> createGroup(@RequestBody GroupDTO groupDTO, @PathVariable UUID userId) {
        GroupDTO groupCreated = service.createGroup(groupDTO, userId);
        return new ResponseEntity<>(groupCreated, HttpStatus.CREATED);
    }

    @PostMapping("/join/{groupId}/{userId}")
    public ResponseEntity<RelationshipGroupWantJoin> joinGroup(@PathVariable UUID groupId, @PathVariable UUID userId) {
        RelationshipGroupWantJoin groupCreated = service.joinGroup(groupId, userId);
        return new ResponseEntity<>(groupCreated, HttpStatus.CREATED);
    }

    @PostMapping("/accept/{groupId}/{userId}")
    public ResponseEntity<UserRelationsDTO> acceptGroup(@PathVariable UUID groupId, @PathVariable UUID userId) {
        UserRelationsDTO joinAccepted = service.acceptGroup(groupId, userId);
        return new ResponseEntity<>(joinAccepted, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        List<GroupDTO> userDTOs = service.getAllGroups();
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

}
