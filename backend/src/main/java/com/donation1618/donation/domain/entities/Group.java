package com.donation1618.donation.domain.entities;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
@Data
@Node("Group")
public class Group {
    @Id
    private String id;
    private String name;
    @Relationship(type = "MEMBER_OF", direction = Relationship.Direction.OUTGOING)
    private RelationshipGroupMemberOf relationshipGroupMemberOf;
}
