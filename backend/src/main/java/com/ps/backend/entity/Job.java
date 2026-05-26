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
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "tbl_job")
public class Job extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @CreationTimestamp
    @CreatedDate
    private Instant datePosted;
    private Instant lastDate;
    @Column(name = "APPLICATION_COUNT",columnDefinition = "integer default 0")
    private int applicationCount = 0;
    @Column(name = "FEATURED",columnDefinition = "boolean default false")
    private boolean featured = false;
    @Column(name = "URGENT",columnDefinition = "boolean default false")
    private boolean urgent = false;
    @Column(name = "REMOTE" ,columnDefinition = "boolean default false")
    private boolean remote = false;
    @Column(name = "STATUS",columnDefinition = "varchar(255) default 'NEW'")
    private String status = "NEW";
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "savedJobs")
    public Set<Users> users;

    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "job")
    private Set<JobApplication> jobApplications;

}
