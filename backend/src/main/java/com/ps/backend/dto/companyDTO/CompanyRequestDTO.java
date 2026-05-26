package com.ps.backend.dto.companyDTO;

import com.ps.backend.enums.CompanyField;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CompanyRequestDTO {
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
}
