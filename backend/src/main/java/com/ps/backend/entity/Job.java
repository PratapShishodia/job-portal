package com.ps.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "tbl_job")
public class Job extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long jobId;
    @Column(name = "TITLE")
    private String jobTitle;
    @Column(name = "LOCATIONS")
    private String jobLocations;
    @Column(name = "WORKTYPE")
    private String workType;
    @Column(name = "JOBTYPE")
    private String jobType;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "EXP_LVL")
    private int experienceLvl;
    @Column(name = "SALARY_MIN")
    private int salaryMin;
    @Column(name = "SALARY_MAX")
    private int salaryMax;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "DESCRIPTION")
    private String jobDesc;
    @Column(name = "REQUIREMENTS")
    private String requirements;
    @Column(name = "BENEFITS")
    private String benefits;
    @CreationTimestamp
    @CreatedDate
    @Column(name = "POSTED")
    private Instant datePosted;
    @Column(name = "DEADLINE")
    private Instant lastDate;
    @Column(name = "Applications",columnDefinition = "integer default 0")
    private int applicationCount = 0;
    @Column(name = "FEATURED",columnDefinition = "boolean default false")
    private boolean featured = false;
    @Column(name = "URGENT",columnDefinition = "boolean default false")
    private boolean urgent = false;
    @Column(name = "REMOTE",columnDefinition = "boolean default false")
    private boolean remote = false;
    @Column(name = "STATUS",columnDefinition = "varchar(255) default 'NEW'")
    private String status = "NEW";
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "companyId")
    private Company company;
}
