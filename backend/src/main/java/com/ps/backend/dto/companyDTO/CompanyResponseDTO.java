package com.ps.backend.dto.companyDTO;

import com.ps.backend.dto.jobDTO.JobResponseDTO;
import com.ps.backend.enums.CompanyField;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class CompanyResponseDTO {
    private Long companyId;
    private String companyName;
    private String companyDesc;
    private String companyLogo;
    private CompanyField companyField;
    private int employeeCount;
    private String size;
    private int founded;
    private int openPosition;
    private BigDecimal ratings;
    private String Locations;
    private List<JobResponseDTO> jobs;
}

