package com.ps.backend.mapper;

import com.ps.backend.dto.companyDTO.CompanyRequestDTO;
import com.ps.backend.dto.companyDTO.CompanyResponseDTO;
import com.ps.backend.entity.Company;

public class CompanyDTOMapper {

    public static CompanyResponseDTO toDTO(Company company){
        CompanyResponseDTO dto = new CompanyResponseDTO();
        dto.setCompanyId(company.getCompanyId());
        dto.setCompanyName(company.getCompanyName());
        dto.setCompanyDesc(company.getCompanyDesc());
        dto.setCompanyLogo(company.getCompanyLogo());
        dto.setCompanyField(company.getCompanyField());
        dto.setEmployeeCount(company.getEmployeeCount());
        dto.setSize(company.getSize());
        dto.setFounded(company.getFounded());
        dto.setOpenPosition(company.getOpenPosition());
        dto.setRatings(company.getRatings());
        dto.setLocations(company.getLocations());
        return dto;
    }

    public static Company toEntity(CompanyRequestDTO dto){
        Company company = new Company();
        company.setCompanyName(dto.getCompanyName());
        company.setCompanyDesc(dto.getCompanyDesc());
        company.setCompanyLogo(dto.getCompanyLogo());
        company.setCompanyField(dto.getCompanyField());
        company.setEmployeeCount(dto.getEmployeeCount());
        company.setSize(dto.getSize());
        company.setFounded(dto.getFounded());
        company.setLocations(dto.getLocations());
        return company;
    }

}
