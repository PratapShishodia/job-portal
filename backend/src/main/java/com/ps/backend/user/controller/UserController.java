package com.ps.backend.user.controller;

import com.ps.backend.dto.LoginDTO;
import com.ps.backend.dto.UserRequestDTO;
import com.ps.backend.dto.UserResponseDTO;
import com.ps.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user" )
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(@RequestParam(required = false,defaultValue = "0") int page_num, @RequestParam(required = false,defaultValue = "10") int page_size) {
        return ResponseEntity.ok(userService.getUserAllUsers(page_num,page_size));
    }

    @GetMapping("/{role}")
    public ResponseEntity<List<UserResponseDTO>> getUsersByRole(@RequestParam(required = false,defaultValue = "0") int page_num, @RequestParam(required = false,defaultValue = "10") int page_size,@PathVariable String role) {
        return ResponseEntity.ok(userService.getUserAllUsersByRole(page_num,page_size,role));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO userRequestDTO) {
        System.out.println("Inside addUser");
        return ResponseEntity.ok(userService.addUser(userRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody LoginDTO  loginDTO) {
        System.out.println("Inside login");
        return ResponseEntity.ok(userService.login(loginDTO));
    }
}
