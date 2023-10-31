package com.donation1618.donation.repository;

import com.donation1618.donation.domain.entities.RelationshipGroupMemberOf;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RelationshipGroupMemberOfRepository extends Neo4jRepository<RelationshipGroupMemberOf, String> {
}
