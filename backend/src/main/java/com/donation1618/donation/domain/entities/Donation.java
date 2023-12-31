package com.donation1618.donation.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Node("Donation")
public class Donation {
    @Id
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime createAt;
    @Relationship(type = "HAVE_REQUEST", direction = Relationship.Direction.INCOMING)
    private List<DonationRequest> donationHaveRequest = new ArrayList<>();
    public Donation() {
        this.id = UUID.randomUUID();
        this.createAt = LocalDateTime.now();
    }
}
