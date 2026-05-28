package com.ps.backend.user.controller;

import com.ps.backend.dto.commonDTO.LoginDTO;
import com.ps.backend.dto.userDTO.UsersRequestDTO;
import com.ps.backend.dto.userDTO.UsersResponseDTO;
import com.ps.backend.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UsersResponseDTO> getuserByID(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUsers(email));
    }

    @PostMapping("/signup")
    public ResponseEntity<UsersResponseDTO> signup(@Valid @RequestBody UsersRequestDTO usersRequestDTO) {
        return ResponseEntity.ok(userService.signUp(usersRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@Valid @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(userService.login(loginDTO));
    }
}
