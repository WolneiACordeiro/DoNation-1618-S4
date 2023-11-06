package com.donation1618.donation.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class DonationDTO {
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime createAt;
    public DonationDTO() {
        this.id = UUID.randomUUID();
        this.createAt = LocalDateTime.now();
    }
}
