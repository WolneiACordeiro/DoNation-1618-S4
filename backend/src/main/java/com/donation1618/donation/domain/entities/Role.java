package com.donation1618.donation.domain.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "roleId")
@Node("Role")
public class Role {
    @Id
    @GeneratedValue
    private Long roleId;
    @NotBlank
    private Roles name;
    public Role(Roles name) {
        this.name = name;
    }
}
