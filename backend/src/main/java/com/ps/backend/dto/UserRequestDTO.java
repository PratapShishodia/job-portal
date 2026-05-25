package com.ps.backend.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDTO {
    @NotBlank(message = "Username is Required")
    private String userName;
    @NotBlank(message = "UserEmail is Required")
    private String userEmail;
    @NotBlank(message = "Password is Required")
    private String password;
    @NotBlank(message = "Number is Required")
    private String number;
    @NotBlank(message = "Role is Required")
    private String role;
}
