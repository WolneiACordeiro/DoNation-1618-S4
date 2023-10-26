package com.donation1618.donation.service.impl;

import com.donation1618.donation.domain.dto.GroupDTO;
import com.donation1618.donation.domain.entities.Group;
import com.donation1618.donation.domain.entities.RelationshipGroupMemberOf;
import com.donation1618.donation.domain.entities.RelationshipGroupWantJoin;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.domain.entities.enums.GroupHierarchyEnum;
import com.donation1618.donation.domain.entities.enums.JoinGroupStatusEnum;
import com.donation1618.donation.repository.GroupRepository;
import com.donation1618.donation.repository.RelationshipGroupWantJoinRepository;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.GroupService;
import com.donation1618.donation.service.exceptions.ForbiddenException;
import com.donation1618.donation.service.exceptions.ResourceNotFoundException;
import com.donation1618.donation.service.impl.mapper.GroupMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final RelationshipGroupWantJoinRepository relationJoinRepository;
    private final GroupMapper groupMapper;
    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, UserRepository userRepository, GroupMapper groupMapper, RelationshipGroupWantJoinRepository relationJoinRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.groupMapper = groupMapper;
        this.relationJoinRepository = relationJoinRepository;
    }
    @Override
    @Transactional
    public GroupDTO createGroup(GroupDTO groupDTO, UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId));
        Group group = groupMapper.dtoToEntity(groupDTO);
        RelationshipGroupMemberOf relationship = new RelationshipGroupMemberOf(UUID.randomUUID(), GroupHierarchyEnum.ADMINISTRATOR, group);
        user.addGroupMembership(relationship);
        userRepository.save(user);
        Group savedGroup = groupRepository.save(group);
        return groupMapper.entityToDto(savedGroup);
    }
    @Override
    @Transactional
    public RelationshipGroupWantJoin joinGroup(UUID groupId, UUID userId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado com o ID: " + groupId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId));
        Boolean hasRecentWantJoin = userRepository.hasRecentWantJoin(userId, groupId);
        if (hasRecentWantJoin) {
            String status = userRepository.findMostRecentWantJoinStatus(userId, groupId);
            throw new ForbiddenException("Usuário já tem uma solicitação em status: " + status + " com o grupo.");
        } else {
            RelationshipGroupWantJoin relationship = new RelationshipGroupWantJoin(UUID.randomUUID(), JoinGroupStatusEnum.WAITING, group);
            user.addGroupJoin(relationship);
            userRepository.save(user);
            groupRepository.save(group);
            return relationship;
        }
    }

    @Override
    @Transactional
    public RelationshipGroupWantJoin acceptGroup(UUID groupId, UUID userId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado com o ID: " + groupId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId));
        if (userRepository.hasRecentWantJoin(userId, groupId)) {
            String status = userRepository.findMostRecentWantJoinStatus(userId, groupId);
            System.out.println("Status: " + status);
            if (Objects.equals(status, "WAITING")) {
                UUID relationId = userRepository.findWantJoinRelationId(userId, groupId);
                if (relationId != null) {
                    RelationshipGroupWantJoin relationship = userRepository.findByRelationId(relationId.toString());
                    if (relationship != null) {
                        relationship.setStatus(JoinGroupStatusEnum.ACCEPTED);
                        user.addGroupJoin(relationship);
                        userRepository.save(user);
                        groupRepository.save(group);
                        return relationship;
                    } else {
                        throw new ResourceNotFoundException("Relacionamento não encontrado com relationId: " + relationId);
                    }
                } else {
                    throw new ResourceNotFoundException("relationId não encontrado para userId: " + userId + " e groupId: " + groupId);
                }
            } else {
                throw new ForbiddenException("Essa solicitação já foi respondida.");
            }
        } else {
            throw new ForbiddenException("Usuário não tem uma solicitação enviada para esse grupo.");
        }
    }
}