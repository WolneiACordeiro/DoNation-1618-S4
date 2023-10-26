package com.donation1618.donation.repository;

import com.donation1618.donation.domain.entities.RelationshipGroupWantJoin;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RelationshipGroupWantJoinRepository extends Neo4jRepository<RelationshipGroupWantJoin, Long> {
}
