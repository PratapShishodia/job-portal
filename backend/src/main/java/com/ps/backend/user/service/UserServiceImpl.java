package com.ps.backend.user.service;

import com.ps.backend.dto.commonDTO.LoginDTO;
import com.ps.backend.dto.userDTO.UsersRequestDTO;
import com.ps.backend.dto.userDTO.UsersResponseDTO;
import com.ps.backend.entity.Profile;
import com.ps.backend.entity.Users;
import com.ps.backend.mapper.ProfileDTOMapper;
import com.ps.backend.mapper.UserDTOMapper;
import com.ps.backend.repository.UserRepo;
import com.ps.backend.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final BCryptPasswordEncoder encoder;

    public UsersResponseDTO getUsers(String email) {
        return UserDTOMapper.toDTO(userRepo.findByUserEmail(email).orElseThrow(()->new RuntimeException("User not found")));
    }

    @Transactional
    public UsersResponseDTO signUp(UsersRequestDTO usersRequestDTO) {
        Users user = UserDTOMapper.toEntity(usersRequestDTO);
        user.setPassword(encoder.encode(usersRequestDTO.getPassword()));
        return UserDTOMapper.toDTO(userRepo.save(user));
    }

    public Map<String, String> login(LoginDTO loginDTO) {
        String email = loginDTO.email();
        String password = loginDTO.password();
        Map<String,String> map = new HashMap<>();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        System.out.println("Username: " + email);
        System.out.println("Password: " + password);
        System.out.println("Authentication: " + authentication.getPrincipal());
        if(authentication.isAuthenticated()) {
            map.put("status","success");
            map.put("token",jwtUtils.generateToken(loginDTO.email()));
        }
        else {
            throw new BadCredentialsException("Bad credentials");
        }
        return map;
    }
}
