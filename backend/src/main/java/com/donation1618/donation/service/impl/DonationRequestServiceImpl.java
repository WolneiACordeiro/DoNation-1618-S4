package com.donation1618.donation.service.impl;

import com.donation1618.donation.domain.dto.DonationDTO;
import com.donation1618.donation.domain.dto.DonationRequestDTO;
import com.donation1618.donation.domain.entities.Donation;
import com.donation1618.donation.domain.entities.DonationRequest;
import com.donation1618.donation.domain.entities.Group;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.domain.entities.enums.DonationRequestEnum;
import com.donation1618.donation.repository.DonationRepository;
import com.donation1618.donation.repository.DonationRequestRepository;
import com.donation1618.donation.repository.GroupRepository;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.DonationRequestService;
import com.donation1618.donation.service.exceptions.ResourceNotFoundException;
import com.donation1618.donation.service.impl.mapper.DonationMapper;
import com.donation1618.donation.service.impl.mapper.DonationRequestMapper;
import com.donation1618.donation.service.impl.mapper.GroupMapper;
import com.donation1618.donation.service.impl.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class DonationRequestServiceImpl implements DonationRequestService {
    private final DonationRequestRepository donationRequestRepository;
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final DonationRequestMapper donationRequestMapper;
    private final UserMapper userMapper;
    private final GroupMapper groupMapper;
    private final DonationMapper donationMapper;

    public DonationRequestServiceImpl(DonationRequestRepository donationRequestRepository, DonationRepository donationRepository, UserRepository userRepository, GroupRepository groupRepository, DonationRequestMapper donationRequestMapper, UserMapper userMapper, GroupMapper groupMapper, DonationMapper donationMapper) {
        this.donationRequestRepository = donationRequestRepository;
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.donationRequestMapper = donationRequestMapper;
        this.userMapper = userMapper;
        this.groupMapper = groupMapper;
        this.donationMapper = donationMapper;
    }
    @Override
    @Transactional
    public DonationRequestDTO createDonationRequest(DonationRequestDTO donationRequestDTO, UUID donationId, UUID userId) {
        Donation donation = donationRepository.findById(donationId).orElseThrow(() -> new ResourceNotFoundException("Doação não encontrada com o ID: " + donationId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId));
        String donatorId = userRepository.findUserIdByDonationId(donationId);
        User donator = userRepository.findById(UUID.fromString(donatorId)).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + donatorId));
        DonationRequest donationRequest = donationRequestMapper.dtoToEntity(donationRequestDTO);
        donationRequest.setStatus(DonationRequestEnum.WAITING);
        donationRequest.setTitle(user.getUsername() + " quer " + donation.getTitle() + " de " + donator.getUsername());
        donation.setDonationHaveRequest(Collections.singletonList(donationRequest));
        user.setUserWantDonation(Collections.singletonList(donationRequest));
        donationRepository.save(donation);
        userRepository.save(user);
        DonationRequest savedDonationRequest = donationRequestRepository.save(donationRequest);
        return donationRequestMapper.entityToDto(savedDonationRequest);
    }
}
