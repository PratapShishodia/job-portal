package com.ps.backend.mapper;

import com.ps.backend.dto.userDTO.UsersRequestDTO;
import com.ps.backend.dto.userDTO.UsersResponseDTO;
import com.ps.backend.entity.Users;

public class UserDTOMapper {

    public static UsersResponseDTO toDTO(Users user) {
        UsersResponseDTO dto = new UsersResponseDTO();

        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setUserEmail(user.getUserEmail());
        dto.setNumber(user.getNumber());
        dto.setRole(user.getRole());

        return dto;
    }

    public static Users toEntity(UsersRequestDTO dto) {
        Users user = new Users();

        user.setUserName(dto.getUserName());
        user.setUserEmail(dto.getUserEmail());
        user.setPassword(dto.getPassword());
        user.setNumber(dto.getNumber());
        user.setRole(dto.getRole());

        return user;
    }


}
