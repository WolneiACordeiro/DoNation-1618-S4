package com.donation1618.donation.repository;

import com.donation1618.donation.domain.entities.RelationshipGroupMemberOf;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipGroupMemberOfRepository extends Neo4jRepository<RelationshipGroupMemberOf, String> {
}
