package com.donation1618.donation.domain.entities;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RelationshipProperties
public class RelationshipGroupMemberOf {
    @RelationshipId @GeneratedValue
    private String id;
    private String role;
    @TargetNode
    private Group group;
}
