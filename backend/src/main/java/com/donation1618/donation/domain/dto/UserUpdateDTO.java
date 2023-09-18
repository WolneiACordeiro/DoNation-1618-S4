package com.donation1618.donation.domain.dto;

import com.donation1618.donation.domain.entities.Role;
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
public class UserUpdateDTO {
    private String id;
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "O nome de usuário deve ter de 3 a 80 caracteres")
    private String username;
    @Email
    private String email;
    @NotBlank(message = "Campo requerido")
    @Size(min = 8, max = 16, message = "A senha deve ter de 8 a 16 caracteres")
    private String password;
    private List<Role> roles = new ArrayList<>();
}
