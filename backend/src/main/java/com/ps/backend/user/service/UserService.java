package com.ps.backend.user.service;

import com.ps.backend.dto.LoginDTO;
import com.ps.backend.dto.UserRequestDTO;
import com.ps.backend.dto.UserResponseDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<UserResponseDTO> getUserAllUsers(int page_num,int page_size);
    public List<UserResponseDTO> getUserAllUsersByRole(int page_num, int page_size,String role);
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO);
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO);
    public UserResponseDTO deleteUser(long id);
    public Map<String,String> login(LoginDTO loginDTO);
    public UserResponseDTO getUserByEmail(String email);
}
