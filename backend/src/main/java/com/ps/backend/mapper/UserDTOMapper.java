package com.ps.backend.mapper;

import com.ps.backend.dto.userDTO.UsersRequestDTO;
import com.ps.backend.dto.userDTO.UsersResponseDTO;
import com.ps.backend.entity.Users;

public class UserDTOMapper {

    public static UsersResponseDTO toDTO(Users user) {
        UsersResponseDTO userResponseDTO = new UsersResponseDTO();
        userResponseDTO.setUserId(user.getUserId());
        userResponseDTO.setUserName(user.getUserName());
        userResponseDTO.setUserEmail(user.getUserEmail());
        userResponseDTO.setNumber(user.getNumber());
        userResponseDTO.setRole(user.getRole());
        if(user.getProfile() != null) {
            userResponseDTO.setProfile(ProfileDTOMapper.toDTO(user.getProfile()));
        }
        if(user.getJobApplications() != null) {
            userResponseDTO.setJobApplications(user.getJobApplications().stream().map(JobApplicationDTOMapper::toDTO).toList());
        }
        return userResponseDTO;
    }

    public static Users toEntity(UsersRequestDTO userRequestDTO) {
        Users user = new Users();
        user.setUserName(userRequestDTO.getUserName());
        user.setUserEmail(userRequestDTO.getUserEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setNumber(userRequestDTO.getNumber());
        user.setRole(userRequestDTO.getRole());
        return user;
    }


}
