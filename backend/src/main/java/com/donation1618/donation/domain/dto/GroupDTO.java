package com.donation1618.donation.domain.dto;

import com.donation1618.donation.domain.entities.Donation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GroupDTO {
    private UUID id;
    private String name;
    @Relationship(type = "HAVE_DONATION", direction = Relationship.Direction.OUTGOING)
    private List<Donation> groupHaveDonation = new ArrayList<>();
    public GroupDTO() {
        this.id = UUID.randomUUID();
    }
}
