package com.donation1618.donation.domain.entities;

import com.donation1618.donation.domain.entities.enums.GroupHierarchyEnum;
import com.donation1618.donation.domain.entities.enums.JoinGroupStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Getter
@Setter
@RelationshipProperties
public class RelationshipGroupWantJoin {
    @RelationshipId
    private String id;
    private JoinGroupStatusEnum status;
    @TargetNode
    private Group group;

    public RelationshipGroupWantJoin(JoinGroupStatusEnum status, Group group) {
        this.status = status;
        this.group = group;
    }
}