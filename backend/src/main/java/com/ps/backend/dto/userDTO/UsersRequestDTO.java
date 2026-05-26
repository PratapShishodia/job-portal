package com.ps.backend.dto.userDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersRequestDTO {
    private String userName;
    private String userEmail;
    private String password;
    private String number;
    private String role;
    private long profile;
}
