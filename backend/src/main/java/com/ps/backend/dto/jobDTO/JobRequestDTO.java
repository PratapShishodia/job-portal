package com.ps.backend.dto.jobDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class JobRequestDTO {
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
    private Instant lastDate;
    private boolean featured;
    private boolean urgent;
    private boolean remote;
    private Long companyId;
}
