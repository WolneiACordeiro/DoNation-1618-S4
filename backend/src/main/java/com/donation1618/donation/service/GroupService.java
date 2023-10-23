package com.donation1618.donation.service;

import com.donation1618.donation.domain.entities.Group;

import java.util.UUID;

public interface GroupService {
    Group createGroup(Group group, UUID userId);
}
