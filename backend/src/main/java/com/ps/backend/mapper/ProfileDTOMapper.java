package com.ps.backend.mapper;

import com.ps.backend.dto.ProfileRequestDTO;
import com.ps.backend.dto.ProfileResponseDTO;
import com.ps.backend.entity.Profile;

public class ProfileDTOMapper {

    public static ProfileResponseDTO toDTO(Profile profile) {
        ProfileResponseDTO dto = new ProfileResponseDTO();
        dto.setProfileId(profile.getProfileId());
        dto.setFirstName(profile.getFirstName());
        dto.setLastName(profile.getLastName());
        dto.setJobTitle(profile.getJobTitle());
        dto.setBaseLocation(profile.getBaseLocation());
        dto.setExperience(profile.getExperience());
        dto.setBio(profile.getBio());
        dto.setWebsite(profile.getWebsite());
        dto.setProfilePic(profile.getProfilePic());
        dto.setPicName(profile.getPicName());
        dto.setPicType(profile.getPicType());
        dto.setPicType(profile.getPicType());
        dto.setResume(profile.getResume());
        dto.setResumeName(profile.getResumeName());
        dto.setResumeType(profile.getResumeType());
        dto.setUser(profile.getUser().getUserId());
        return  dto;
    }

    public static Profile toEntity(ProfileRequestDTO dto) {
        Profile profile = new Profile();
        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
        profile.setJobTitle(dto.getJobTitle());
        profile.setBaseLocation(dto.getBaseLocation());
        profile.setExperience(dto.getExperience());
        profile.setBio(dto.getBio());
        profile.setWebsite(dto.getWebsite());
        profile.setProfilePic(dto.getProfilePic());
        profile.setPicName(dto.getPicName());
        profile.setPicType(dto.getPicType());
        profile.setResume(dto.getResume());
        profile.setResumeName(dto.getResumeName());
        profile.setResumeType(dto.getResumeType());
        return  profile;
    }
}
