package com.ps.backend.mapper;


import com.ps.backend.dto.jobApplicationDTO.JobApplicationRequestDTO;
import com.ps.backend.dto.jobApplicationDTO.JobApplicationResponseDTO;
import com.ps.backend.entity.JobApplication;

public class JobApplicationDTOMapper {

    public static JobApplicationResponseDTO toDTO(JobApplication application) {
        JobApplicationResponseDTO dto = new JobApplicationResponseDTO();
        dto.setApplicationId(application.getApplicationId());
        dto.setAppliedAt(application.getAppliedAt());
        dto.setStatus(application.getStatus());
        dto.setCoverLetter(application.getCoverLetter());
        dto.setNotes(application.getNotes());

        if(application.getUser() != null){
            dto.setUserId(application.getUser().getUserId());
        }

        if(application.getJob() != null){
            dto.setJobId(application.getJob().getJobId());
        }

        return dto;
    };

    public static JobApplication toEntity(JobApplicationRequestDTO dto){
        JobApplication application = new JobApplication();
        application.setCoverLetter(dto.getCoverLetter());
        application.setNotes(dto.getNotes());
        return application;
    }
}
