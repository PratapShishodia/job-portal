package com.ps.backend.mapper;

import com.ps.backend.dto.jobDTO.JobRequestDTO;
import com.ps.backend.dto.jobDTO.JobResponseDTO;
import com.ps.backend.entity.Job;

import java.util.stream.Collectors;

public class JobDTOMapper {
    public static JobResponseDTO toDTO(Job job) {
        JobResponseDTO dto = new JobResponseDTO();
        dto.setJobId(job.getJobId());
        dto.setJobTitle(job.getJobTitle());
        dto.setJobLocations(job.getJobLocations());
        dto.setWorkType(job.getWorkType());
        dto.setJobType(job.getJobType());
        dto.setCategory(job.getCategory());
        dto.setExperienceLvl(job.getExperienceLvl());
        dto.setSalaryMin(job.getSalaryMin());
        dto.setSalaryMax(job.getSalaryMax());
        dto.setCurrency(job.getCurrency());
        dto.setJobDesc(job.getJobDesc());
        dto.setRequirements(job.getRequirements());
        dto.setBenefits(job.getBenefits());
        dto.setDatePosted(job.getDatePosted());
        dto.setLastDate(job.getLastDate());
        dto.setApplicationCount(job.getApplicationCount());
        dto.setFeatured(job.isFeatured());
        dto.setUrgent(job.isUrgent());
        dto.setRemote(job.isRemote());
        dto.setStatus(job.getStatus());
        dto.setCompanyid(job.getCompany().getCompanyId());
        dto.setJobApplications(job.getJobApplications().stream().map(JobApplicationDTOMapper::toDTO).collect(Collectors.toSet()));
        return dto;
    }

    public static Job toEntity(JobRequestDTO dto) {
        Job job = new Job();
        job.setJobTitle(dto.getJobTitle());
        job.setJobLocations(dto.getJobLocations());
        job.setWorkType(dto.getWorkType());
        job.setJobType(dto.getJobType());
        job.setCategory(dto.getCategory());
        job.setExperienceLvl(dto.getExperienceLvl());
        job.setSalaryMin(dto.getSalaryMin());
        job.setSalaryMax(dto.getSalaryMax());
        job.setCurrency(dto.getCurrency());
        job.setJobDesc(dto.getJobDesc());
        job.setRequirements(dto.getRequirements());
        job.setBenefits(dto.getBenefits());
        job.setDatePosted(dto.getDatePosted());
        job.setLastDate(dto.getLastDate());
        job.setApplicationCount(dto.getApplicationCount());
        job.setFeatured(dto.isFeatured());
        job.setUrgent(dto.isUrgent());
        job.setRemote(dto.isRemote());
        job.setStatus(dto.getStatus());
        return job;
    }
}
