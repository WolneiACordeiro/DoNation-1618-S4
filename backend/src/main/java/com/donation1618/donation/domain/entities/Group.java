package com.donation1618.donation.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Node("Group")
public class Group {
    @Id
    private UUID id;
    private String name;
    @Relationship(type = "HAVE_DONATION", direction = Relationship.Direction.INCOMING)
    private List<Donation> groupHaveDonation = new ArrayList<>();
    public Group() {
        this.id = UUID.randomUUID();
    }
}
