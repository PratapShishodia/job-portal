package com.ps.backend.jobApplication.service;

import com.ps.backend.dto.commonDTO.PageResponseDTO;
import com.ps.backend.dto.jobApplicationDTO.JobApplicationRequestDTO;
import com.ps.backend.dto.jobApplicationDTO.JobApplicationResponseDTO;
import com.ps.backend.entity.JobApplication;
import com.ps.backend.mapper.JobApplicationDTOMapper;
import com.ps.backend.repository.JobApplicationRepo;
import com.ps.backend.repository.JobRepo;
import com.ps.backend.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepo  jobApplicationRepo;
    private final JobRepo  jobRepo;
    private final UserRepo userRepo;

    @Transactional
    public JobApplicationResponseDTO addJob(JobApplicationRequestDTO jobApplicationRequestDTO) {
        JobApplication  jobApplication = JobApplicationDTOMapper.toEntity(jobApplicationRequestDTO);
        jobApplication.setUser(userRepo.findById(jobApplicationRequestDTO.getUserId()).orElseThrow(()->new IllegalArgumentException("User not found!")));
        jobApplication.setJob(jobRepo.findById(jobApplicationRequestDTO.getJobId()).orElseThrow(()->new IllegalArgumentException("Job not found!")));
        return JobApplicationDTOMapper.toDTO(jobApplicationRepo.save(jobApplication));
    }

    public PageResponseDTO<JobApplicationResponseDTO> getAllJobsApplication(int page_name, int page_size,String sort_by,String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sort_by).descending() : Sort.by(sort_by).ascending();
        PageRequest pageRequest = PageRequest.of(page_name, page_size,sort);
        Page<JobApplication> jobApplicationPage = jobApplicationRepo.findAll(pageRequest);
        List<JobApplicationResponseDTO> content =  jobApplicationPage.getContent().stream().map(JobApplicationDTOMapper::toDTO).toList();
        PageResponseDTO<JobApplicationResponseDTO> response = new PageResponseDTO<>();
        response.setContent(content);
        response.setPageNumber(jobApplicationPage.getNumber());
        response.setPageSize(jobApplicationPage.getSize());
        response.setTotalElements(jobApplicationPage.getTotalElements());
        response.setTotalPages(jobApplicationPage.getTotalPages());
        response.setLastPage(jobApplicationPage.isLast());
        return response;
    }

    public JobApplicationResponseDTO getJobByID(long application_id) {
        return JobApplicationDTOMapper.toDTO(jobApplicationRepo.findById(application_id).orElseThrow(()->new IllegalArgumentException("Job Application not found!")));
    }
}
