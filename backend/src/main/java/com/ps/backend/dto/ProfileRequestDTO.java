package com.ps.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProfileRequestDTO {
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
