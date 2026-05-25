package com.ps.backend.mapper;

import com.ps.backend.dto.CompanyRequestDTO;
import com.ps.backend.dto.CompanyResponseDTO;
import com.ps.backend.entity.Company;
import com.ps.backend.entity.Job;

public class CompanyDTOMapper {

    public static CompanyResponseDTO toDTO(Company company){
        CompanyResponseDTO companyResponseDTO = new CompanyResponseDTO();
        companyResponseDTO.setCompanyId(company.getCompanyId());
        companyResponseDTO.setCompanyName(company.getCompanyName());
        companyResponseDTO.setCompanyDesc(company.getCompanyDesc());
        companyResponseDTO.setCompanyLogo(company.getCompanyLogo());
        companyResponseDTO.setFounded(company.getFounded());
        companyResponseDTO.setSize(company.getSize());
        companyResponseDTO.setEmployeeCount(company.getEmployeeCount());
        companyResponseDTO.setLocations(company.getLocations());
        companyResponseDTO.setOpenPosition(company.getOpenPosition());
        companyResponseDTO.setCompanyField(company.getCompanyField());
        companyResponseDTO.setRatings(company.getRatings());
        companyResponseDTO.setJobs(company.getJobs().stream().map(Job::getJobId).toList());
        return companyResponseDTO;
    }

    public static Company toEntity(CompanyRequestDTO requestDTO){
        Company company = new Company();
        company.setCompanyName(requestDTO.getCompanyName());
        company.setCompanyLogo(requestDTO.getCompanyLogo());
        company.setCompanyDesc(requestDTO.getCompanyDesc());
        company.setLocations(requestDTO.getLocations());
        company.setSize(requestDTO.getSize());
        company.setCompanyField(requestDTO.getCompanyField());
        company.setEmployeeCount(requestDTO.getEmployeeCount());
        company.setFounded(requestDTO.getFounded());
        company.setOpenPosition(requestDTO.getOpenPosition());
        company.setRatings(requestDTO.getRatings());
        return company;
    }

}
