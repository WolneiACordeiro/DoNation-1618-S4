package com.donation1618.donation.service.impl;

import com.donation1618.donation.domain.entities.Group;
import com.donation1618.donation.domain.entities.RelationshipGroupMemberOf;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.repository.GroupRepository;
import com.donation1618.donation.repository.RelationshipGroupMemberOfRepository;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.GroupService;
import com.donation1618.donation.service.exceptions.ResourceNotFoundException;
import com.donation1618.donation.utils.ExternalIdGenerator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class GroupServiceImpl implements GroupService {
private final GroupRepository groupRepository;
private final UserRepository userRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, UserRepository userRepository, RelationshipGroupMemberOfRepository relationshipGroupMemberOfRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.relationshipGroupMemberOfRepository = relationshipGroupMemberOfRepository;
    }

    @Override
    @Transactional
    public Group createGroup(Group group, String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId));
        group.setId(ExternalIdGenerator.generateUniqueId());
        group.setName(group.getName());
        RelationshipGroupMemberOf relationship = new RelationshipGroupMemberOf();
        relationship.setRole("admin");
        relationship.setGroup(group);
        user.setRelationshipGroupMemberOf(relationship);
        userRepository.save(user);
        Group saveGroup = groupRepository.save(group);
        return saveGroup;
    }
}
