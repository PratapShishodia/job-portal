package com.ps.backend.dto;

import com.ps.backend.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class JobResponseDTO {
    private long jobId;
    private String jobTitle;
    private String jobLocations;
    private String workType;
    private String jobType;
    private String category;
    private int experienceLvl;
    private int salaryMin;
    private int salaryMax;
    private String currency;
    private String jobDesc;
    private String requirements;
    private String benefits;
    private Instant datePosted;
    private Instant lastDate;
    private int applicationCount;
    private boolean featured;
    private boolean urgent;
    private boolean remote;
    private String status;
    private Long companyId;
}
