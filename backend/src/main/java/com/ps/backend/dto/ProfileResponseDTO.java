package com.ps.backend.dto;

import com.ps.backend.entity.Users;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
public class ProfileResponseDTO {
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
    private long user;
}
