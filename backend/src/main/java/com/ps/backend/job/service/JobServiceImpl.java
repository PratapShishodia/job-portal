package com.ps.backend.job.service;

import com.ps.backend.dto.commonDTO.PageResponseDTO;
import com.ps.backend.dto.jobDTO.JobRequestDTO;
import com.ps.backend.dto.jobDTO.JobResponseDTO;
import com.ps.backend.entity.Job;
import com.ps.backend.mapper.JobDTOMapper;
import com.ps.backend.repository.CompanyRepo;
import com.ps.backend.repository.JobRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JobServiceImpl implements JobService {

    private final JobRepo jobRepo;
    private final CompanyRepo companyRepo;

    @Transactional
    public JobResponseDTO addJob(JobRequestDTO jobRequestDTO) {
        Job  job = JobDTOMapper.toEntity(jobRequestDTO);
        job.setCompany(companyRepo.findById(jobRequestDTO.getCompanyId()).orElseThrow(() -> new RuntimeException("Company Not Found")));
        return JobDTOMapper.toDTO(jobRepo.save(job));
    }

    public PageResponseDTO<JobResponseDTO> getAllJobs(int pageNum, int pageSize,String sort_by,String direction) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Job> jobs = jobRepo.findAll(pageable);
        List<JobResponseDTO> content = jobs.getContent().stream().map(JobDTOMapper::toDTO).toList();
        PageResponseDTO<JobResponseDTO> response = new PageResponseDTO<>();
        response.setContent(content);
        response.setPageNumber(jobs.getNumber());
        response.setPageSize(jobs.getSize());
        response.setTotalElements(jobs.getTotalElements());
        response.setTotalPages(jobs.getTotalPages());
        response.setLastPage(jobs.isLast());
        return response;
    }

    public PageResponseDTO<JobResponseDTO> getAllJobsByCompanyID(int pageNum, int pageSize,String sort_by,String direction,long companyId) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Job> jobs = jobRepo.findByCompanyCompanyId(pageable,companyId);
        List<JobResponseDTO> content =  jobs.getContent().stream().map(JobDTOMapper::toDTO).toList();
        PageResponseDTO<JobResponseDTO> response = new PageResponseDTO<>();
        response.setContent(content);
        response.setPageNumber(jobs.getNumber());
        response.setPageSize(jobs.getSize());
        response.setTotalElements(jobs.getTotalElements());
        response.setTotalPages(jobs.getTotalPages());
        response.setLastPage(jobs.isLast());
        return response;
    }
}
