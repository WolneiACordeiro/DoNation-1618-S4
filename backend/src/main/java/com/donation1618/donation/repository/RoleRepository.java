package com.donation1618.donation.repository;

import com.donation1618.donation.domain.entities.Role;
import com.donation1618.donation.domain.entities.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends Neo4jRepository<Role, String> {
    Role findByName(String name);
}
