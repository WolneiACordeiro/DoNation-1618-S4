package com.donation1618.donation.repository;

import com.donation1618.donation.entities.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, Long> {
}
