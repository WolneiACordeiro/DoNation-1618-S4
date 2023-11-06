package com.donation1618.donation.service.impl.mapper;
import com.donation1618.donation.domain.dto.DonationRequestDTO;
import com.donation1618.donation.domain.entities.DonationRequest;
import org.springframework.stereotype.Component;
@Component
public class DonationRequestMapper {
    public DonationRequestDTO entityToDto(DonationRequest donationRequest) {
        DonationRequestDTO donationRequestDTO = new DonationRequestDTO();
        donationRequestDTO.setId(donationRequest.getId());
        donationRequestDTO.setTitle(donationRequest.getTitle());
        donationRequestDTO.setDescription(donationRequest.getDescription());
        donationRequestDTO.setStatus(donationRequest.getStatus());
        donationRequestDTO.setCreateAt(donationRequest.getCreateAt());
        return donationRequestDTO;
    }
    public DonationRequest dtoToEntity(DonationRequestDTO donationRequestDTO) {
        DonationRequest donationRequest = new DonationRequest();
        donationRequest.setTitle(donationRequestDTO.getTitle());
        donationRequest.setDescription(donationRequestDTO.getDescription());
        donationRequest.setStatus(donationRequestDTO.getStatus());
        donationRequest.setCreateAt(donationRequestDTO.getCreateAt());
        return donationRequest;
    }
}
