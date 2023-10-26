package com.donation1618.donation.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GroupDTO {
    private UUID id;
    private String name;
    public GroupDTO(UUID id, String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
    public GroupDTO() {
        this.id = UUID.randomUUID();
    }
}
