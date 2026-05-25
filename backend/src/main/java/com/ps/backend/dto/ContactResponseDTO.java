package com.ps.backend.dto;

import com.ps.backend.enums.ContactSubject;
import com.ps.backend.enums.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactResponseDTO {
    private long contactId;
    private String fullName;
    private Roles userType;
    private ContactSubject subject;
    public String message;
    public String status;
    public String userEmail;
}
