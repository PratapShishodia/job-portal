package com.ps.backend.user.service;

import com.ps.backend.dto.LoginDTO;
import com.ps.backend.dto.UserRequestDTO;
import com.ps.backend.dto.UserResponseDTO;
import com.ps.backend.entity.Users;
import com.ps.backend.mapper.UserDTOMapper;
import com.ps.backend.repository.UserRepo;
import com.ps.backend.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo  userRepo;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public List<UserResponseDTO> getUserAllUsers(int page_num, int page_size) {
        Pageable pageable = PageRequest.of(page_num, page_size);
        Page<Users> users = userRepo.findAll(pageable);
        List<Users>  usersList = users.getContent();
        return usersList.stream().map(UserDTOMapper::toDTO).toList();
    }

    public List<UserResponseDTO> getUserAllUsersByRole(int page_num, int page_size,String role) {
        Pageable pageable = PageRequest.of(page_num, page_size);
        Page<Users> users = userRepo.findAllByRole(pageable,role);
        List<Users>  usersList = users.getContent();
        return usersList.stream().map(UserDTOMapper::toDTO).toList();
    }

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        Users user = UserDTOMapper.toEntity(userRequestDTO);
        user.setPassword(encoder.encode(userRequestDTO.getPassword()));
        return UserDTOMapper.toDTO(userRepo.save(user));
    }

    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) {
        return null;
    }

    public UserResponseDTO deleteUser(long id) {
        return null;
    }

    public Map<String, String> login(LoginDTO loginDTO) {
        String username = loginDTO.email().toLowerCase();
        String password = loginDTO.password();
        Map<String,String> map = new HashMap<>();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        System.out.println("Authentication: " + authentication);
        if (authentication.isAuthenticated()) {
            map.put("JWT",jwtUtils.generateToken(loginDTO.email()));
        }
        else{
            throw new BadCredentialsException("Bad credentials");
        }
        return map;
    }

    public UserResponseDTO getUserByEmail(String email) {
        Users user = userRepo.findByUserEmail(email).orElseThrow(()->new RuntimeException("User not found"));
        return UserDTOMapper.toDTO(user);
    }
}
