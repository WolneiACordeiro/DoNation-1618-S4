package com.donation1618.donation.service.impl.mapper;

import com.donation1618.donation.domain.dto.GroupDTO;
import com.donation1618.donation.domain.entities.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {
    public GroupDTO entityToDto(Group group) {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(group.getId());
        groupDTO.setName(group.getName());
        return groupDTO;
    }
    public Group dtoToEntity(GroupDTO groupDTO) {
        Group group = new Group();
        group.setName(groupDTO.getName());
        return group;
    }
}
