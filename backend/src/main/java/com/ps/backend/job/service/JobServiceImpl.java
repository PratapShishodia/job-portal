package com.ps.backend.job.service;

import com.ps.backend.dto.JobRequestDTO;
import com.ps.backend.dto.JobResponseDTO;
import com.ps.backend.entity.Job;
import com.ps.backend.mapper.JobDTOMapper;
import com.ps.backend.repository.CompanyRepo;
import com.ps.backend.repository.JobRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepo jobRepo;
    private final CompanyRepo companyRepo;

    public JobResponseDTO createJob(JobRequestDTO dto) {
        Job job = JobDTOMapper.toEntity(dto);
        job.setCompany(companyRepo.findById(dto.getCompanyId()).orElseThrow(() -> new RuntimeException("Company Not Found")));
        return JobDTOMapper.toDTO(jobRepo.save(job));
    }

    public JobResponseDTO updateJob(JobRequestDTO dto, long jobId) {
        return null;
    }

    public String deleteJob(long jobId) {
        Job job = jobRepo.findById(jobId).orElseThrow(() -> new RuntimeException("Job Not Found"));
        jobRepo.delete(job);
        return "Job with ID: "+jobId+" deleted Successfully";
    }

    public JobResponseDTO getJobByID(long jobId) {
        return JobDTOMapper.toDTO(jobRepo.findById(jobId).orElseThrow(() -> new RuntimeException("Job Not Found")));
    }

    public List<JobResponseDTO> getJobByCompanyId(int page_num, int page_size, Long companyId) {
        Pageable pageable = PageRequest.of(page_num, page_size);
        Page<Job> jobs = jobRepo.findAllByCompany(pageable,companyId);
        List<Job>  jobList = jobs.getContent();
        return jobList.stream().map(JobDTOMapper::toDTO).toList();
    }

    public List<JobResponseDTO> getJobs(int page_num, int page_size) {
        Pageable pageable = PageRequest.of(page_num, page_size);
        Page<Job> jobs = jobRepo.findAll(pageable);
        List<Job>  jobList = jobs.getContent();
        return jobList.stream().map(JobDTOMapper::toDTO).toList();
    }


}
