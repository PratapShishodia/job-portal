package com.ps.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Setter
@Getter
@Entity
@Table(name = "tbl_profile")
public class Profile extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;
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
    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "userId")
    private Users user;
}
