package com.donation1618.donation.utils.data;

import com.donation1618.donation.domain.entities.Role;
import com.donation1618.donation.repository.RoleRepository;
import com.donation1618.donation.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Neo4jDataInitializer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public Neo4jDataInitializer(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }



    @PostConstruct
    public void initializeData() {
//        Role role1 = new Role(0L, "ROLE_USER");
//        Role role2 = new Role(1L,"ROLE_ADMIN");
//        roleRepository.save(role1);
//        roleRepository.save(role2);


//        Role customer = new Role(0L,"USER_ROLE");
//        User user1 = new User(0L, "User1","user1@example.com", "password1", (List<String>) role1);
//        User user2 = new User(1L, "User2","user2@example.com", "password2", (List<String>) role2);
//
//        userRepository.save(user1);
//        userRepository.save(user2);

    }
}
