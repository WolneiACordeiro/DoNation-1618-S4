package com.donation1618.donation.repository;

import com.donation1618.donation.domain.entities.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends Neo4jRepository<User, String> {
    boolean existsByEmail(String email);
}
