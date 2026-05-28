package com.ps.backend.dto.jobApplicationDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobApplicationRequestDTO {
    private String status;
    private String coverLetter;
    private String notes;
    private long userId;
    private long jobId;
}
