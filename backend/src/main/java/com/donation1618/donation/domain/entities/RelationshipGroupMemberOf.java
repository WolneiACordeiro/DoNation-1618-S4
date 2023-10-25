package com.donation1618.donation.domain.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.UUID;

@Getter
@Setter
@RelationshipProperties
public class RelationshipGroupMemberOf {
    @RelationshipId
    private String id;
    private String role;
    @TargetNode
    private Group group;

    public RelationshipGroupMemberOf(String role, Group group) {
        this.role = role;
        this.group = group;
    }
}