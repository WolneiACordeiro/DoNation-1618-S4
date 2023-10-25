package com.donation1618.donation.service.impl;

import com.donation1618.donation.domain.entities.Group;
import com.donation1618.donation.domain.entities.RelationshipGroupMemberOf;
import com.donation1618.donation.domain.entities.RelationshipGroupWantJoin;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.domain.entities.enums.GroupHierarchyEnum;
import com.donation1618.donation.domain.entities.enums.JoinGroupStatusEnum;
import com.donation1618.donation.repository.GroupRepository;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.GroupService;
import com.donation1618.donation.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Group createGroup(Group group, UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId));
        group.setName(group.getName());
        RelationshipGroupMemberOf relationship = new RelationshipGroupMemberOf(UUID.randomUUID(),GroupHierarchyEnum.ADMINISTRATOR,group);
        user.addGroupMembership(relationship);
        userRepository.save(user);
        Group saveGroup = groupRepository.save(group);
        return saveGroup;
    }

    @Override
    @Transactional
    public Group joinGroup(UUID groupId, UUID userId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado com o ID: " + groupId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId));
        RelationshipGroupWantJoin relationship = new RelationshipGroupWantJoin(UUID.randomUUID(),JoinGroupStatusEnum.WAITING,group);
        user.addGroupJoin(relationship);
        userRepository.save(user);
        groupRepository.save(group);
        return group;
    }


}