package com.ps.backend.job.service;

import com.ps.backend.dto.JobRequestDTO;
import com.ps.backend.dto.JobResponseDTO;

import java.util.List;

public interface JobService {
    public JobResponseDTO createJob(JobRequestDTO dto);
    public JobResponseDTO updateJob(JobRequestDTO dto,long jobId);
    public String deleteJob(long jobId);
    public JobResponseDTO getJobByID(long jobId);
    public List<JobResponseDTO> getJobByCompanyId(int page_num,int page_size,Long companyId);
    public List<JobResponseDTO> getJobs(int page_num,int page_size);
}
