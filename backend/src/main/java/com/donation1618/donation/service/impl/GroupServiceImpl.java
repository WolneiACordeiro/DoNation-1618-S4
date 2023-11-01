package com.donation1618.donation.service.impl;

import com.donation1618.donation.domain.dto.GroupDTO;
import com.donation1618.donation.domain.dto.UserRelationsDTO;
import com.donation1618.donation.domain.entities.Group;
import com.donation1618.donation.domain.entities.RelationshipGroupMemberOf;
import com.donation1618.donation.domain.entities.RelationshipGroupWantJoin;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.domain.entities.enums.GroupHierarchyEnum;
import com.donation1618.donation.domain.entities.enums.JoinGroupStatusEnum;
import com.donation1618.donation.repository.GroupRepository;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.GroupService;
import com.donation1618.donation.service.exceptions.ForbiddenException;
import com.donation1618.donation.service.exceptions.ResourceNotFoundException;
import com.donation1618.donation.service.impl.mapper.GroupMapper;
import com.donation1618.donation.service.impl.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final GroupMapper groupMapper;
    private final UserMapper userMapper;
    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, UserRepository userRepository, GroupMapper groupMapper, UserMapper userMapper) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.groupMapper = groupMapper;
        this.userMapper = userMapper;
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
    public UserRelationsDTO acceptGroup(UUID groupId, UUID userId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado com o ID: " + groupId));
        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId)));

        User user = userOptional.get();
        UserRelationsDTO userDTO = userMapper.entityOnlyRelationsDto(user);
        List<RelationshipGroupWantJoin> groupWantJoins = userDTO.getGroupWantJoins();
        if(!groupWantJoins.isEmpty()){
            List<RelationshipGroupWantJoin> filteredGroupWantJoins = new ArrayList<>();
            for (RelationshipGroupWantJoin groupWantJoin : groupWantJoins) {
                if (JoinGroupStatusEnum.WAITING.equals(groupWantJoin.getStatus()) && groupId.equals(groupWantJoin.getGroup().getId())) {
                    RelationshipGroupMemberOf relationship = new RelationshipGroupMemberOf(UUID.randomUUID(), GroupHierarchyEnum.MEMBER, group);
                    groupWantJoin.setStatus(JoinGroupStatusEnum.ACCEPTED);
                    filteredGroupWantJoins.add(groupWantJoin);
                    user.addGroupMembership(relationship);
                }
            }
            if(!filteredGroupWantJoins.isEmpty()){
                userDTO.setGroupWantJoins(filteredGroupWantJoins);
                userRepository.save(user);
                return userDTO;
            } else {
                throw new ForbiddenException("O usuário não tem solcitação em WAITING com este grupo!");
            }
        } else {
            throw new ForbiddenException("O usuário não tem nenhuma solicitação ativa!");
        }

    }

    @Override
    public List<GroupDTO> getAllGroups() {
        return null;
    }

}
