package com.donation1618.donation.entities;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
@Data
@Node
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
}
