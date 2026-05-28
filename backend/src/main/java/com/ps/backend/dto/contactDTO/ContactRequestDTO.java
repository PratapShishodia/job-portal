package com.ps.backend.dto.contactDTO;

import com.ps.backend.enums.ContactSubject;
import com.ps.backend.enums.Roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactRequestDTO {
    private String fullName;
    private Roles userType;
    private ContactSubject subject;
    public String message;
    public String userEmail;
}
