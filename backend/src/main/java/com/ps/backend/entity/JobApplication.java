package com.ps.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "tbl_job_application")
public class JobApplication extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;
    private Instant appliedAt;
    private String status;
    private String coverLetter;
    private String notes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Job job;
}
