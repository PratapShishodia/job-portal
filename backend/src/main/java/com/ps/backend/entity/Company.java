package com.ps.backend.entity;

import com.ps.backend.enums.CompanyField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tbl_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long companyId;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "COMPANY_DESC")
    private String companyDesc;
    @Column(name = "COMPANY_LOGO")
    private String companyLogo;
    @Enumerated(EnumType.STRING)
    @Column(name = "COMPANY_FIELD")
    private CompanyField companyField;
    @Column(name = "EMPLOYEE_COUNT")
    private int employeeCount;
    @Column(name ="COMPANY_SIZE")
    private String size;
    @Column(name = "FOUNDED")
    private int founded;
    @Column(name = "OPEN_POSITIONS",columnDefinition = "integer default 0")
    private int openPosition = 0;
    @Column(name = "RATINGS",columnDefinition = "numeric(3,2) default 0.0")
    private BigDecimal ratings = BigDecimal.ZERO;
    @Column(name = "LOCATIONS")
    private String Locations;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "company")
    private List<Job> jobs;
}
