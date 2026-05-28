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
    public ProfileResponseDTO updateProfile(ProfileRequestDTO profileRequestDTO) {
        return null;
    }

    public ProfileResponseDTO getProfileByID(long profile_id) {
        Profile profile = profileRepo.findById(profile_id).orElseThrow(()->new RuntimeException("Profile Not Found"));
        return ProfileDTOMapper.toDTO(profile);
    }
}
