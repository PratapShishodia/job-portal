package com.ps.backend.user.controller;

import com.ps.backend.dto.commonDTO.LoginDTO;
import com.ps.backend.dto.commonDTO.PasswordChangeDTO;
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
    public ResponseEntity<UsersResponseDTO> getUserByID(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUsers(email));
    }

    @PostMapping("/signup")
    public ResponseEntity<UsersResponseDTO> signUp(@Valid @RequestBody UsersRequestDTO usersRequestDTO) {
        return ResponseEntity.ok(userService.signUp(usersRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@Valid @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(userService.login(loginDTO));
    }

    @PatchMapping("/update")
    public ResponseEntity<UsersResponseDTO> updateUser(@RequestParam int userId, @Valid @RequestBody UsersRequestDTO usersRequestDTO) {
        return ResponseEntity.ok(userService.update(userId,usersRequestDTO));
    }

    @PatchMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestParam int userId, @Valid @RequestBody PasswordChangeDTO passwordChangeDTO) {
        return ResponseEntity.ok(userService.changePassword(userId,passwordChangeDTO));
    }

}
