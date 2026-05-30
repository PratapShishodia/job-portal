package com.ps.backend.job.service;

import com.ps.backend.dto.commonDTO.PageResponseDTO;
import com.ps.backend.dto.jobDTO.JobRequestDTO;
import com.ps.backend.dto.jobDTO.JobResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobService {
    public JobResponseDTO addJob(JobRequestDTO jobRequestDTO);
    public PageResponseDTO<JobResponseDTO> getAllJobs(int pageNum, int pageSize, String sortBy, String direction);
    public PageResponseDTO<JobResponseDTO> getAllJobsByCompanyID(int pageNum, int pageSize,String sortBy,String direction,long companyId);
    public PageResponseDTO<JobResponseDTO> getAllJobsByWorkType(int pageNum, int pageSize,String sortBy,String direction,String workType);
}
