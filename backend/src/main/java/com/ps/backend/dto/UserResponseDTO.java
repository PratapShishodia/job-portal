package com.ps.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserResponseDTO {
    private long userId;
    private String userName;
    private String userEmail;
    private String number;
    private String role;
    private long profileId;
}
