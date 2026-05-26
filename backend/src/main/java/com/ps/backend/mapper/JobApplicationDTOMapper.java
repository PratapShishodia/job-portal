package com.ps.backend.mapper;


import com.ps.backend.dto.jobApplicationDTO.JobApplicationRequestDTO;
import com.ps.backend.dto.jobApplicationDTO.JobApplicationResponseDTO;
import com.ps.backend.entity.JobApplication;

public class JobApplicationDTOMapper {

    public static JobApplicationResponseDTO toDTO(JobApplication jobApplication) {
        JobApplicationResponseDTO responseDTO = new JobApplicationResponseDTO();
        responseDTO.setApplicationId(jobApplication.getApplicationId());
        responseDTO.setStatus(jobApplication.getStatus());
        responseDTO.setCoverLetter(jobApplication.getCoverLetter());
        responseDTO.setNotes(jobApplication.getNotes());
        responseDTO.setUser(jobApplication.getUser().getUserId());
        return responseDTO;
    };

    public static JobApplication toEntity(JobApplicationRequestDTO requestDTO) {
        JobApplication jobApplication = new JobApplication();
        jobApplication.setStatus(requestDTO.getStatus());
        jobApplication.setCoverLetter(requestDTO.getCoverLetter());
        jobApplication.setNotes(requestDTO.getNotes());
        return jobApplication;
    }
}
