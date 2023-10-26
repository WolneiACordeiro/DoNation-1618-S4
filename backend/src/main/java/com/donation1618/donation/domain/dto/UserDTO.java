package com.donation1618.donation.domain.dto;

import com.donation1618.donation.domain.entities.RelationshipGroupMemberOf;
import com.donation1618.donation.domain.entities.RelationshipGroupWantJoin;
import com.donation1618.donation.domain.entities.Role;
import com.donation1618.donation.utils.validator.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private UUID id;
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "O nome de usuário deve ter de 3 a 80 caracteres")
    private String username;
    @Email
    @UniqueEmail
    private String email;
    @NotBlank(message = "Campo requerido")
    @Size(min = 8, max = 16, message = "A senha deve ter de 8 a 16 caracteres")
    private String password;
    private List<Role> roles = new ArrayList<>();
    private List<RelationshipGroupMemberOf> groupMemberships = new ArrayList<>();
    private List<RelationshipGroupWantJoin> groupWantJoins = new ArrayList<>();
}
