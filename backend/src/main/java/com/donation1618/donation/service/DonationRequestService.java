package com.donation1618.donation.service;

import com.donation1618.donation.domain.dto.DonationDTO;
import com.donation1618.donation.domain.dto.DonationRequestDTO;

import java.util.UUID;

public interface DonationRequestService {
    public DonationRequestDTO createDonationRequest(DonationRequestDTO donationRequestDTO, UUID donationId, UUID userId);
}
