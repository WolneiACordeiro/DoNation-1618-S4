package com.donation1618.donation.domain.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Node("User")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    @Relationship(type = "HAS_ROLE", direction = Relationship.Direction.OUTGOING)
    private List<Role> roles = new ArrayList<>();
    @Relationship(type = "MEMBER_OF", direction = Relationship.Direction.OUTGOING)
    private RelationshipGroupMemberOf relationshipGroupMemberOf;
}
