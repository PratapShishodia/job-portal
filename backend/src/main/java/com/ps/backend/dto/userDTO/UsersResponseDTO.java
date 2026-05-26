package com.ps.backend.dto.userDTO;

import com.ps.backend.dto.jobApplicationDTO.JobApplicationResponseDTO;
import com.ps.backend.dto.profileDTO.ProfileResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsersResponseDTO {
    private long userId;
    private String userName;
    private String userEmail;
    private String number;
    private String role;
    private ProfileResponseDTO profile;
    private List<JobApplicationResponseDTO> jobApplications;
}
