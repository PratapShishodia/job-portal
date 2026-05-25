package com.ps.backend.profile.controller;

import com.ps.backend.dto.ProfileRequestDTO;
import com.ps.backend.dto.ProfileResponseDTO;
import com.ps.backend.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public ResponseEntity<ProfileResponseDTO> getProfileById(@RequestParam Long profileId){
        return ResponseEntity.ok(profileService.getProfileById(profileId));
    }

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> saveProfile(@RequestBody ProfileRequestDTO profileRequestDTO){
        return ResponseEntity.ok(profileService.addProfile(profileRequestDTO));
    }
}
