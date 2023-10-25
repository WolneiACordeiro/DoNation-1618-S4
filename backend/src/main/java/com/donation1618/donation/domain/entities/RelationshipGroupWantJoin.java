package com.donation1618.donation.domain.entities;

import com.donation1618.donation.domain.entities.enums.GroupHierarchyEnum;
import com.donation1618.donation.domain.entities.enums.JoinGroupStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.UUID;

@Getter
@Setter
@RelationshipProperties
public class RelationshipGroupWantJoin {
    @RelationshipId
    private String id;
    private UUID relationId;
    private JoinGroupStatusEnum status;
    @TargetNode
    private Group group;

    public RelationshipGroupWantJoin(UUID relationId, JoinGroupStatusEnum status, Group group) {
        this.relationId = UUID.randomUUID();
        this.status = status;
        this.group = group;
    }
}