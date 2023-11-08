package com.donation1618.donation.repository;
import com.donation1618.donation.domain.entities.User;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserRepository extends Neo4jRepository<User, UUID> {
    boolean existsByEmail(String email);
    @Query("MATCH (u:User {id: $userId})-[r]-(g:Group {id: $groupId}) RETURN r")
    List<Relationship> findRelationshipsBetweenUserAndGroup(UUID userId, UUID groupId);
    @Query("MATCH (u:User {id: $userId})-[r:WANT_JOIN]->(g:Group {id: $groupId}) RETURN COUNT(r) > 0")
    boolean hasRecentWantJoin(UUID userId, UUID groupId);
    @Query("MATCH (u:User {id: $userId})-[r:WANT_JOIN]->(g:Group {id: $groupId}) " +
            "WITH r " +
            "ORDER BY r.properties.identity DESC " +
            "LIMIT 1 " +
            "RETURN properties(r).status AS status")
    String findMostRecentWantJoinStatus(UUID userId, UUID groupId);
    @Query("MATCH (donation:Donation {id: $donationId})<-[:MAKE_DONATION]-(user:User)" +
            "RETURN user.id")
    String findUserIdByDonationId(UUID donationId);
}
