package com.ps.backend.entity;

import com.ps.backend.enums.CompanyField;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tbl_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long companyId;
    @Column(name = "NAME",unique = true,nullable = false)
    private String companyName;
    @Column(name = "DESCRIPTION",nullable = false)
    private String companyDesc;
    @Column(name = "LOGO")
    private String companyLogo;
    @Column(name = "INDUSTRY")
    @Enumerated(EnumType.STRING)
    private CompanyField companyField;
    @Column(name = "EMPLOYEE_COUNT")
    private int employeeCount;
    @Column(name = "SIZE")
    private String size;
    @Column(name = "FOUNDED")
    private int founded;
    @Column(name = "OPEN_POSITIONS",columnDefinition = "integer default 0")
    private int openPosition = 0;
    @Column(name = "RATINGS",nullable = false, precision = 3, scale = 2,columnDefinition = "numeric(3,2) default 0")
    private BigDecimal ratings = BigDecimal.ZERO;
    @Column(name = "LOCATIONS",nullable = false)
    private String Locations;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Job> jobs = new ArrayList<>();
}
