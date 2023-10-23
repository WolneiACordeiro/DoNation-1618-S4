package com.donation1618.donation.domain.entities;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
@RelationshipProperties
public class RelationshipGroupMemberOf {
    @RelationshipId @GeneratedValue
    private String id;
    private String role;
    @TargetNode
    private Group group;
}