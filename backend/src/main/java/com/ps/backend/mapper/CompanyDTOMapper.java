package com.ps.backend.mapper;

import com.ps.backend.dto.companyDTO.CompanyRequestDTO;
import com.ps.backend.dto.companyDTO.CompanyResponseDTO;
import com.ps.backend.entity.Company;

public class CompanyDTOMapper {

    public static CompanyResponseDTO toDTO(Company company){
        CompanyResponseDTO responseDTO = new CompanyResponseDTO();
        responseDTO.setCompanyId(company.getCompanyId());
        responseDTO.setCompanyName(company.getCompanyName());
        responseDTO.setCompanyDesc(company.getCompanyDesc());
        responseDTO.setCompanyLogo(company.getCompanyLogo());
        responseDTO.setCompanyField(company.getCompanyField());
        responseDTO.setEmployeeCount(company.getEmployeeCount());
        responseDTO.setSize(company.getSize());
        responseDTO.setFounded(company.getFounded());
        responseDTO.setOpenPosition(company.getOpenPosition());
        responseDTO.setRatings(company.getRatings());
        responseDTO.setLocations(company.getLocations());
        if(company.getJobs() != null){
            responseDTO.setJobs(company.getJobs().stream().map(JobDTOMapper::toDTO).toList());
        }
        return responseDTO;
    }

    public static Company toEntity(CompanyRequestDTO requestDTO){
        Company company = new Company();
        company.setCompanyName(requestDTO.getCompanyName());
        company.setCompanyDesc(requestDTO.getCompanyDesc());
        company.setCompanyLogo(requestDTO.getCompanyLogo());
        company.setCompanyField(requestDTO.getCompanyField());
        company.setEmployeeCount(requestDTO.getEmployeeCount());
        company.setSize(requestDTO.getSize());
        company.setFounded(requestDTO.getFounded());
        company.setOpenPosition(requestDTO.getOpenPosition());
        company.setRatings(requestDTO.getRatings());
        company.setLocations(requestDTO.getLocations());
        return company;
    }

}
