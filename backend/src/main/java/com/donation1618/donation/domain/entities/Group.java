package com.donation1618.donation.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Node("Group")
public class Group {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    public Group() {
        this.id = UUID.randomUUID();
    }
}
