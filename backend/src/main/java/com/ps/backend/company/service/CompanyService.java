package com.ps.backend.company.service;

import com.ps.backend.dto.CompanyRequestDTO;
import com.ps.backend.dto.CompanyResponseDTO;

import java.util.List;

public interface CompanyService {
    public List<CompanyResponseDTO> getAllCompanies(int page_num,int page_size);
    public List<CompanyResponseDTO> getAllCompaniesByField(int page_num,int page_size,String companyField);
    public CompanyResponseDTO addCompany(CompanyRequestDTO requestDTO);
}
