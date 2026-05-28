package com.ps.backend.dto.jobApplicationDTO;

import com.ps.backend.dto.userDTO.UsersResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class JobApplicationResponseDTO {
    private Long applicationId;
    private Instant appliedAt;
    private String status;
    private String coverLetter;
    private String notes;
    private long userId;
    private long jobId;
}
