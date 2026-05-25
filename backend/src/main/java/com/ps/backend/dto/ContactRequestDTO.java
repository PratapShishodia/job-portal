package com.ps.backend.dto;

import com.ps.backend.enums.ContactSubject;
import com.ps.backend.enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactRequestDTO {
    @NotBlank(message = "Name is Required")
    private String fullName;
    @NotNull(message = "UserType is Required")
    private Roles userType;
    @NotNull(message = "Subject is Required")
    private ContactSubject subject;
    @NotBlank(message = "Message is Required")
    public String message;
    public String status;
    @Email(message = "Email is not Valid")
    public String userEmail;
}
