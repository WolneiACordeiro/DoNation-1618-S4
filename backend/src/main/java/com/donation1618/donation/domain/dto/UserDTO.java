package com.donation1618.donation.domain.dto;

import com.donation1618.donation.domain.entities.Role;
import com.donation1618.donation.domain.entities.Roles;
import com.donation1618.donation.utils.validator.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank(message = "Field required")
    @Size(min = 3, max = 80, message = "Username must be 3 to 80 characters long")
    private String username;
    @Email
    @UniqueEmail
    private String email;
    @NotBlank(message = "Field required")
    @Size(min = 8, max = 16, message = "Password must be 8 to 16 characters long")
    private String password;
    private List<Role> roles = new ArrayList<>();
}
