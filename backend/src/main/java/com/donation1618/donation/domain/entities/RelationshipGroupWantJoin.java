package com.donation1618.donation.domain.entities;

import com.donation1618.donation.domain.entities.enums.JoinGroupStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.UUID;

@Getter
@Setter
@RelationshipProperties
@NoArgsConstructor
@AllArgsConstructor
public class RelationshipGroupWantJoin {
    @RelationshipId
    private Long identity;
    private UUID relationId;
    private JoinGroupStatusEnum status;
    @TargetNode
    private Group group;

    public RelationshipGroupWantJoin(UUID relationId, JoinGroupStatusEnum status, Group group) {
        this.relationId = UUID.randomUUID();
        this.status = status;
        this.group = group;
    }

    public RelationshipGroupWantJoin(JoinGroupStatusEnum status, Group group) {
        this.status = status;
        this.group = group;
    }
}
