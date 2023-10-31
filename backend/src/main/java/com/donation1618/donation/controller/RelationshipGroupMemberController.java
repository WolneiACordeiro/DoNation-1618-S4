package com.donation1618.donation.controller;

import com.donation1618.donation.domain.entities.RelationshipGroupMemberOf;
import com.donation1618.donation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/relations")
public class RelationshipGroupMemberController {
    @Autowired
    private final UserRepository relationshipGroupMemberOfRepository;

    public RelationshipGroupMemberController(UserRepository relationshipGroupMemberOfRepository) {
        this.relationshipGroupMemberOfRepository = relationshipGroupMemberOfRepository;
    }

    @GetMapping("/{groupId}/{userId}")
    public ResponseEntity<List<RelationshipGroupMemberOf>> findRelations(@PathVariable UUID groupId, @PathVariable UUID userId) {
        List<RelationshipGroupMemberOf> result = relationshipGroupMemberOfRepository.findRelationshipsByUserIdAndGroupId(groupId, userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
