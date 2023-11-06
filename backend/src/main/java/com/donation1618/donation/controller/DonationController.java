package com.donation1618.donation.controller;

import com.donation1618.donation.domain.dto.DonationDTO;
import com.donation1618.donation.domain.dto.GroupDTO;
import com.donation1618.donation.domain.dto.UserRelationsDTO;
import com.donation1618.donation.domain.entities.relations.RelationshipGroupWantJoin;
import com.donation1618.donation.service.DonationService;
import com.donation1618.donation.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/donations")
public class DonationController {
    private final DonationService service;

    @Autowired
    public DonationController(DonationService donationService) {
        this.service = donationService;
    }

    @PostMapping("/create/{groupId}/{userId}")
    public ResponseEntity<DonationDTO> createDonation(@RequestBody DonationDTO donationDTO, @PathVariable UUID groupId, @PathVariable UUID userId) {
        DonationDTO donationCreated = service.createDonation(donationDTO, groupId, userId);
        return new ResponseEntity<>(donationCreated, HttpStatus.CREATED);
    }

}
