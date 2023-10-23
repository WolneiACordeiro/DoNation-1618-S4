package com.donation1618.donation.domain.entities;

import com.donation1618.donation.domain.entities.enums.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Node("Role")
public class Role {
    @Id
    @GeneratedValue
    private UUID id;
    @NotBlank
    private RoleEnum name;
    public Role(RoleEnum name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
