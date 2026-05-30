package com.ps.backend.profile.service;

import com.ps.backend.dto.profileDTO.ProfileRequestDTO;
import com.ps.backend.dto.profileDTO.ProfileResponseDTO;

public interface ProfileService{
    public ProfileResponseDTO addProfile(ProfileRequestDTO profileRequestDTO);
    public ProfileResponseDTO updateProfile(long profile_id,ProfileRequestDTO profileRequestDTO);
    public ProfileResponseDTO getProfileByID(long profile_id);
}
