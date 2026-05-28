package com.ps.backend.profile.controller;

import com.ps.backend.dto.profileDTO.ProfileRequestDTO;
import com.ps.backend.dto.profileDTO.ProfileResponseDTO;
import com.ps.backend.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResponseDTO> getProfileByID(@PathVariable long profileId) {
        return ResponseEntity.ok(profileService.getProfileByID(profileId));
    }

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> saveProfile(@RequestBody ProfileRequestDTO profileRequestDTO) {
        return ResponseEntity.ok(profileService.addProfile(profileRequestDTO));
    }

//    @PostMapping
//    public ResponseEntity<List<ProfileResponseDTO>> saveProfile(@RequestBody List<ProfileRequestDTO> profileRequestDTO) {
//        List<ProfileResponseDTO> profileResponseDTOList = new ArrayList<>();
//        for (ProfileRequestDTO profileRequestDTO1 : profileRequestDTO) {
//            profileResponseDTOList.add(profileService.addProfile(profileRequestDTO1));
//        }
//        return ResponseEntity.ok(profileResponseDTOList);
//    }
}
