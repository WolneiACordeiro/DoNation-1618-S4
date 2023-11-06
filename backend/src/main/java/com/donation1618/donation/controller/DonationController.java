package com.donation1618.donation.controller;

import com.donation1618.donation.domain.dto.DonationDTO;
import com.donation1618.donation.domain.dto.DonationRequestDTO;
import com.donation1618.donation.service.DonationRequestService;
import com.donation1618.donation.service.DonationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/donations")
public class DonationController {
    private final DonationService service;
    private final DonationRequestService requestService;
    public DonationController(DonationService service, DonationRequestService requestService) {
        this.service = service;
        this.requestService = requestService;
    }
    @PostMapping("/create/{groupId}/{userId}")
    public ResponseEntity<DonationDTO> createDonation(@RequestBody DonationDTO donationDTO, @PathVariable UUID groupId, @PathVariable UUID userId) {
        DonationDTO donationCreated = service.createDonation(donationDTO, groupId, userId);
        return new ResponseEntity<>(donationCreated, HttpStatus.CREATED);
    }
    @PostMapping("/request/{donationId}/{userId}")
    public ResponseEntity<DonationRequestDTO> requestDonation(@RequestBody DonationRequestDTO donationRequestDTO, @PathVariable UUID donationId, @PathVariable UUID userId) {
        DonationRequestDTO donationRequestCreated = requestService.createDonationRequest(donationRequestDTO, donationId, userId);
        return new ResponseEntity<>(donationRequestCreated, HttpStatus.CREATED);
    }

}
