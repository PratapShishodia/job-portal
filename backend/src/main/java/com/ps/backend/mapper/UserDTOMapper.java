package com.ps.backend.mapper;

import com.ps.backend.dto.ProfileResponseDTO;
import com.ps.backend.dto.UserRequestDTO;
import com.ps.backend.dto.UserResponseDTO;
import com.ps.backend.entity.Users;
import com.ps.backend.user.controller.UserController;

public class UserDTOMapper {

    public static UserResponseDTO toDTO(Users user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(user.getUserId());
        userResponseDTO.setUserName(user.getUserName());
        userResponseDTO.setUserEmail(user.getUserEmail());
        userResponseDTO.setNumber(user.getNumber());
        userResponseDTO.setRole(user.getRole());
        if(user.getProfile() != null) {
            userResponseDTO.setProfileId(user.getProfile().getProfileId());
        }
        return userResponseDTO;
    }

    public static Users toEntity(UserRequestDTO userRequestDTO) {
        Users user = new Users();
        user.setUserName(userRequestDTO.getUserName());
        user.setUserEmail(userRequestDTO.getUserEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setNumber(userRequestDTO.getNumber());
        user.setRole(userRequestDTO.getRole());
        return user;
    }


}
