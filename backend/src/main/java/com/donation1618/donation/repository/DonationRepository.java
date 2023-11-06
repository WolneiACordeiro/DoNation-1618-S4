package com.donation1618.donation.repository;
import com.donation1618.donation.domain.entities.Donation;
import com.donation1618.donation.domain.entities.User;
import com.donation1618.donation.domain.entities.relations.RelationshipGroupMemberOf;
import com.donation1618.donation.domain.entities.relations.RelationshipGroupWantJoin;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DonationRepository extends Neo4jRepository<Donation, UUID> {
}
