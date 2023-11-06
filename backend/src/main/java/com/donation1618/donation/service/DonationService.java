package com.donation1618.donation.service;

import com.donation1618.donation.domain.dto.DonationDTO;

import java.util.UUID;

public interface DonationService {
    public DonationDTO createDonation(DonationDTO donationDTO, UUID groupId, UUID userId);
}
