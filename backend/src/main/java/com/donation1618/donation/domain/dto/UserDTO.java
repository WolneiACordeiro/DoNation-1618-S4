package com.donation1618.donation.domain.dto;

import com.donation1618.donation.utils.validator.UniqueEmail;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    @Email
    @UniqueEmail
    private String email;
    private String password;
}
