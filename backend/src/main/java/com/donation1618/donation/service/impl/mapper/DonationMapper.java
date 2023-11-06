package com.donation1618.donation.service.impl.mapper;

import com.donation1618.donation.domain.dto.DonationDTO;
import com.donation1618.donation.domain.entities.Donation;
import org.springframework.stereotype.Component;

@Component
public class DonationMapper {
    public DonationDTO entityToDto(Donation donation) {
        DonationDTO donationDTO = new DonationDTO();
        donationDTO.setId(donation.getId());
        donationDTO.setTitle(donation.getTitle());
        donationDTO.setDescription(donationDTO.getDescription());
        donationDTO.setCreateAt(donationDTO.getCreateAt());
        return donationDTO;
    }
    public Donation dtoToEntity(DonationDTO donationDTO) {
        Donation donation = new Donation();
        donation.setTitle(donationDTO.getTitle());
        donation.setDescription(donation.getDescription());
        donation.setCreateAt(donation.getCreateAt());
        return donation;
    }
}
