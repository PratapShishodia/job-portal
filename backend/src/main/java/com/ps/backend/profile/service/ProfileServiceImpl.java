package com.ps.backend.profile.service;

import com.ps.backend.dto.ProfileRequestDTO;
import com.ps.backend.dto.ProfileResponseDTO;
import com.ps.backend.dto.UserResponseDTO;
import com.ps.backend.entity.Profile;
import com.ps.backend.mapper.ProfileDTOMapper;
import com.ps.backend.repository.ProfileRepo;
import com.ps.backend.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepo profileRepo;
    private final UserRepo userRepo;

    public ProfileResponseDTO getProfileById(Long id) {
        return ProfileDTOMapper.toDTO(profileRepo.findById(id).orElseThrow(()->new RuntimeException("Profile not found!")));
    }

    public ProfileResponseDTO addProfile(ProfileRequestDTO requestDTO) {
        Profile profile = ProfileDTOMapper.toEntity(requestDTO);
        profile.setUser(userRepo.findById(requestDTO.getUser()).orElseThrow(()->new RuntimeException("User not found!")));
        return ProfileDTOMapper.toDTO(profileRepo.save(profile));
    }

    public ProfileResponseDTO updateProfile(ProfileRequestDTO requestDTO) {
        return null;
    }

    public void deleteProfileById(Long id) {
    }
}
