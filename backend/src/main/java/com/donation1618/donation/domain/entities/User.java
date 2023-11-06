package com.donation1618.donation.domain.entities;

import com.donation1618.donation.domain.entities.relations.RelationshipGroupMemberOf;
import com.donation1618.donation.domain.entities.relations.RelationshipGroupWantJoin;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Node("User")
public class User {
    @Id
    private UUID id;
    private String username;
    private String email;
    private String password;
    @Relationship(type = "HAS_ROLE", direction = Relationship.Direction.OUTGOING)
    private List<Role> roles = new ArrayList<>();
    @Relationship(type = "MEMBER_OF", direction = Relationship.Direction.OUTGOING)
    private List<RelationshipGroupMemberOf> groupMemberships = new ArrayList<>();
    @Relationship(type = "WANT_JOIN", direction = Relationship.Direction.OUTGOING)
    private List<RelationshipGroupWantJoin> groupWantJoins = new ArrayList<>();
    @Relationship(type = "MAKE_DONATION", direction = Relationship.Direction.OUTGOING)
    private List<Donation> userMakeDonation = new ArrayList<>();
    @Relationship(type = "WANT_DONATION", direction = Relationship.Direction.OUTGOING)
    private List<DonationRequest> userWantDonation = new ArrayList<>();
    public void addGroupMembership(RelationshipGroupMemberOf membership) {
            groupMemberships.add(membership);
    }
    public void addGroupJoin(RelationshipGroupWantJoin wantJoin) {
        groupWantJoins.add(wantJoin);
    }
    public User() {
        this.id = UUID.randomUUID();
    }
}
