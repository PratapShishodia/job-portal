package com.ps.backend.dto;

import com.ps.backend.entity.Job;
import com.ps.backend.enums.CompanyField;
import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CompanyResponseDTO {
    private long companyId;
    private String companyName;
    private String companyDesc;
    private String companyLogo;
    private CompanyField companyField;
    private int employeeCount;
    private String size;
    private int founded;
    private int openPosition;
    private BigDecimal ratings;
    private String locations;
    private List<Long> jobs;
}
