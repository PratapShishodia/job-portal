package com.ps.backend.jobApplication.service;

import com.ps.backend.dto.commonDTO.PageResponseDTO;
import com.ps.backend.dto.jobApplicationDTO.JobApplicationRequestDTO;
import com.ps.backend.dto.jobApplicationDTO.JobApplicationResponseDTO;

import java.util.List;

public interface JobApplicationService {
    public JobApplicationResponseDTO addJob(JobApplicationRequestDTO jobApplicationRequestDTO);
    public PageResponseDTO<JobApplicationResponseDTO> getAllJobsApplication(int page_name, int page_size,String sort_by,String direction);
    public JobApplicationResponseDTO getJobByID(long application_id);
}
