package com.ps.backend.dto;

import com.ps.backend.entity.Company;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class JobRequestDTO {
    @NotBlank(message = "Job Title is Required")
    private String jobTitle;
    @NotBlank(message = "Job Location is Required")
    private String jobLocations;
    @NotBlank(message = "WorkType is Required")
    private String workType;
    @NotBlank(message = "Job Type is Required")
    private String jobType;
    @NotBlank(message = "Category is Required")
    private String category;
    @NotNull(message = "Experience Level is Required")
    private int experienceLvl;
    @NotNull(message = "Salary Minimum is Required")
    private int salaryMin;
    @NotNull(message = "Salary Maximum is Required")
    private int salaryMax;
    @NotBlank(message = "Currency is Required")
    private String currency;
    @NotBlank(message = "Job Description is Required")
    private String jobDesc;
    @NotBlank(message = "Requirements is Required")
    private String requirements;
    @NotBlank(message = "Benefits is Required")
    private String benefits;
    @NotNull(message = "Last Date is Required")
    private Instant lastDate;
    private boolean featured;
    private boolean urgent;
    private boolean remote;
    private String status;
    @NotNull
    private Long companyId;
}
