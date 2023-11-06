package com.donation1618.donation.service.impl;

import com.donation1618.donation.domain.dto.DonationDTO;
import com.donation1618.donation.domain.entities.Donation;
import com.donation1618.donation.domain.entities.Group;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.repository.DonationRepository;
import com.donation1618.donation.repository.GroupRepository;
import com.donation1618.donation.repository.UserRepository;
import com.donation1618.donation.service.DonationService;
import com.donation1618.donation.service.exceptions.ResourceNotFoundException;
import com.donation1618.donation.service.impl.mapper.DonationMapper;
import com.donation1618.donation.service.impl.mapper.GroupMapper;
import com.donation1618.donation.service.impl.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class DonationServiceImpl implements DonationService {
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final DonationMapper donationMapper;
    private final UserMapper userMapper;
    private final GroupMapper groupMapper;
    @Autowired
    public DonationServiceImpl(DonationRepository donationRepository, UserRepository userRepository, GroupRepository groupRepository, DonationMapper donationMapper, UserMapper userMapper, GroupMapper groupMapper) {
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.donationMapper = donationMapper;
        this.userMapper = userMapper;
        this.groupMapper = groupMapper;
    }

    @Override
    @Transactional
    public DonationDTO createDonation(DonationDTO donationDTO, UUID groupId, UUID userId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado com o ID: " + groupId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId));
        Donation donation = donationMapper.dtoToEntity(donationDTO);
        group.setGroupHaveDonation(Collections.singletonList(donation));
        user.setUserMakeDonation(Collections.singletonList(donation));
        groupRepository.save(group);
        userRepository.save(user);
        Donation savedDonation = donationRepository.save(donation);
        return donationMapper.entityToDto(savedDonation);
    }
}
