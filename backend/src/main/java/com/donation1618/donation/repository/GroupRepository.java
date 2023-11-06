package com.donation1618.donation.repository;
import com.donation1618.donation.domain.entities.Group;
import com.donation1618.donation.domain.entities.Role;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface GroupRepository extends Neo4jRepository<Group, UUID> {
}
