package com.donation1618.donation.service;

import com.donation1618.donation.domain.dto.GroupDTO;
import com.donation1618.donation.domain.entities.RelationshipGroupWantJoin;

import java.util.UUID;

public interface GroupService {
    GroupDTO createGroup(GroupDTO groupDTO, UUID userId);
    RelationshipGroupWantJoin joinGroup(UUID groupId, UUID userId);
    RelationshipGroupWantJoin acceptGroup(UUID groupId, UUID userId);
}
