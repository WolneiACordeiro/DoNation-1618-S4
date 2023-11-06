package com.donation1618.donation.domain.dto;

import com.donation1618.donation.domain.entities.relations.RelationshipGroupWantJoin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRelationsDTO {
    private UUID id;
    private List<RelationshipGroupWantJoin> groupWantJoins = new ArrayList<>();
}
