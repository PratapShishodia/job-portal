package com.ps.backend.company.service;

import com.ps.backend.dto.commonDTO.PageResponseDTO;
import com.ps.backend.dto.companyDTO.CompanyRequestDTO;
import com.ps.backend.dto.companyDTO.CompanyResponseDTO;
import com.ps.backend.enums.CompanyField;

import java.util.List;

public interface CompanyService {
    public PageResponseDTO<CompanyResponseDTO> getCompanyByField(int page_num, int page_size, String sortBy, String sortDirc, String field);
    public PageResponseDTO<CompanyResponseDTO> getAllCompany(int page_num,int page_size,String sortBy,String sortDirc);
    public CompanyResponseDTO addCompany(CompanyRequestDTO companyDTO);
    public CompanyResponseDTO updateCompany(long companyId,CompanyRequestDTO companyDTO);
    public String deleteCompany(long companyId);
}
