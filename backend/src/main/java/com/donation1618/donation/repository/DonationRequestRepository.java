package com.donation1618.donation.repository;
import com.donation1618.donation.domain.entities.Donation;
import com.donation1618.donation.domain.entities.DonationRequest;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DonationRequestRepository extends Neo4jRepository<DonationRequest, UUID> {
}
