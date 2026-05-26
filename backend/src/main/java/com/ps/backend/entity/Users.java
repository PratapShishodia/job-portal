package com.ps.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "tbl_users")
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String userEmail;
    private String password;
    private String number;
    private String role;
    @ManyToMany
    @JoinTable(
            name = "tbl_job_user",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "jobId")
    )
    private Set<Job> savedJobs;
    @OneToOne(mappedBy = "user")
    private Profile profile;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "user")
    private List<JobApplication> jobApplications;

}
