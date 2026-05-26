package com.ps.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tbl_profile")
public class Profile extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String baseLocation;
    private int experience;
    private String bio;
    private String website;
    private String profilePic;
    private String picName;
    private String picType;
    private String resume;
    private String resumeName;
    private String resumeType;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users user;
}
