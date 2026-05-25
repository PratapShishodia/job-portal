package com.ps.backend.profile.service;

import com.ps.backend.dto.ProfileRequestDTO;
import com.ps.backend.dto.ProfileResponseDTO;

public interface ProfileService {
    public ProfileResponseDTO getProfileById(Long id);
    public ProfileResponseDTO addProfile(ProfileRequestDTO responseDTO);
    public ProfileResponseDTO updateProfile(ProfileRequestDTO responseDTO);
    public void deleteProfileById(Long id);
}
