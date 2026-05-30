package com.ps.backend.user.service;

import com.ps.backend.dto.commonDTO.LoginDTO;
import com.ps.backend.dto.commonDTO.PasswordChangeDTO;
import com.ps.backend.dto.userDTO.UsersRequestDTO;
import com.ps.backend.dto.userDTO.UsersResponseDTO;

import java.util.Map;

public interface UserService {
    public UsersResponseDTO getUsers(String email);
    public UsersResponseDTO signUp(UsersRequestDTO usersRequestDTO);
    public Map<String,String> login(LoginDTO loginDTO);
    public UsersResponseDTO update(long userId,UsersRequestDTO usersRequestDTO);
    public String changePassword(long userId, PasswordChangeDTO passwordChangeDTO);
}
