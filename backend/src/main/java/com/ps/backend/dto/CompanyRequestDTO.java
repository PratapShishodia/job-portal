package com.ps.backend.dto;

import com.ps.backend.enums.CompanyField;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CompanyRequestDTO {
    @NotBlank(message = "Company Name is Required")
    private String companyName;
    @NotBlank(message = "Company Description is Required")
    private String companyDesc;
    @NotBlank(message = "Company Logo is Required")
    private String companyLogo;
    @NotNull(message = "Employee Count is Required")
    private int employeeCount;
    @NotBlank(message = "Company Size is Required")
    private String size;
    @NotNull(message = "Company Field is Required")
    private CompanyField companyField;
    @NotNull(message = "Year Founded is Required")
    private int founded;
    private int openPosition;
    private BigDecimal ratings;
    @NotBlank(message = "Location is Required")
    private String locations;
}
