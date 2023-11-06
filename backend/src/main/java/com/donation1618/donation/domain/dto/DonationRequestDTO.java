package com.donation1618.donation.domain.dto;

import com.donation1618.donation.domain.entities.enums.DonationRequestEnum;
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
public class DonationRequestDTO {
    private UUID id;
    private String title;
    private String description;
    private DonationRequestEnum status;
    private LocalDateTime createAt;
    public DonationRequestDTO() {
        this.id = UUID.randomUUID();
        this.createAt = LocalDateTime.now();
    }
}
