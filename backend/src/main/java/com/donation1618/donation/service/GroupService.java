package com.donation1618.donation.service;

import com.donation1618.donation.domain.entities.Group;

public interface GroupService {
    Group createGroup(Group group, String userId);
}
