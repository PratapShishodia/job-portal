package com.ps.backend.dto.profileDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileRequestDTO {
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
    private long user;
}
