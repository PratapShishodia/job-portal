package com.ps.backend.profile.service;

import com.ps.backend.dto.profileDTO.ProfileRequestDTO;
import com.ps.backend.dto.profileDTO.ProfileResponseDTO;
import com.ps.backend.entity.Profile;
import com.ps.backend.mapper.ProfileDTOMapper;
import com.ps.backend.repository.ProfileRepo;
import com.ps.backend.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProfileServiceImpl implements ProfileService {

    private final UserRepo userRepo;
    private final ProfileRepo profileRepo;

    @Transactional
    public ProfileResponseDTO addProfile(ProfileRequestDTO profileRequestDTO) {
        Profile profile = ProfileDTOMapper.toEntity(profileRequestDTO);
        profile.setUser(userRepo.findById(profileRequestDTO.getUserId()).orElseThrow(()->new IllegalArgumentException("User not found!")));
        return ProfileDTOMapper.toDTO(profileRepo.save(profile));
    }

    @Transactional
    public ProfileResponseDTO updateProfile(long profileId,ProfileRequestDTO profileRequestDTO) {
        Profile profile = profileRepo.findById(profileId).orElseThrow(()->new IllegalArgumentException("Profile not found!"));
        if(profileRequestDTO.getFirstName()!=null){
            profile.setFirstName(profileRequestDTO.getFirstName());
        }
        if(profileRequestDTO.getLastName()!=null){
            profile.setLastName(profileRequestDTO.getLastName());
        };
        if(profileRequestDTO.getJobTitle()!=null){
            profile.setJobTitle(profileRequestDTO.getJobTitle());
        };
        if(profileRequestDTO.getBaseLocation()!=null){
            profile.setBaseLocation(profileRequestDTO.getBaseLocation());
        };
        if(profileRequestDTO.getExperience() != 0){
            profile.setExperience(profileRequestDTO.getExperience());
        };
        if(profileRequestDTO.getBio()!=null){
            profile.setBio(profileRequestDTO.getBio());
        };
        if(profileRequestDTO.getWebsite()!=null){
            profile.setWebsite(profileRequestDTO.getWebsite());
        };
        if(profileRequestDTO.getProfilePic()!=null){
            profile.setProfilePic(profileRequestDTO.getProfilePic());
        };
        if(profileRequestDTO.getPicName()!=null){
            profile.setPicName(profileRequestDTO.getPicName());
        };
        if(profileRequestDTO.getPicType()!=null){
            profile.setPicType(profileRequestDTO.getPicType());
        };
        if(profileRequestDTO.getResume()!=null){
            profile.setResume(profileRequestDTO.getResume());
        };
        if(profileRequestDTO.getResumeName()!=null){
            profile.setResumeName(profileRequestDTO.getResumeName());
        };
        if(profileRequestDTO.getResumeType()!=null){
            profile.setResumeType(profileRequestDTO.getResumeType());
        };
//        private String ;
//        private String ;
//        private int ;
//        private String ;
//        private String ;
//        private String ;
//        private String ;
//        private String ;
//        private String ;
//        private String ;
//        private String ;
        return null;
    }

    public ProfileResponseDTO getProfileByID(long profile_id) {
        Profile profile = profileRepo.findById(profile_id).orElseThrow(()->new RuntimeException("Profile Not Found"));
        return ProfileDTOMapper.toDTO(profile);
    }
}
