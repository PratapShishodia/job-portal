package com.ps.backend.company.service;

import com.ps.backend.dto.CompanyRequestDTO;
import com.ps.backend.dto.CompanyResponseDTO;
import com.ps.backend.entity.Company;
import com.ps.backend.enums.CompanyField;
import com.ps.backend.mapper.CompanyDTOMapper;
import com.ps.backend.repository.CompanyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepo companyRepo;

    public List<CompanyResponseDTO> getAllCompanies(int page_num, int page_size) {
        Pageable pageable = PageRequest.of(page_num,page_size);
        Page<Company> companyPage = companyRepo.findAll(pageable);
        List<Company> companyList = companyPage.getContent();
        return companyList.stream().map(CompanyDTOMapper::toDTO).toList();
    }

    public List<CompanyResponseDTO> getAllCompaniesByField(int page_num, int page_size, String companyField) {
        Pageable pageable = PageRequest.of(page_num,page_size);
        Page<Company> companyPage = companyRepo.findAllByCompanyField(pageable, CompanyField.valueOf(companyField));
        List<Company> companyList = companyPage.getContent();
        return companyList.stream().map(CompanyDTOMapper::toDTO).toList();
    }

    public CompanyResponseDTO addCompany(CompanyRequestDTO requestDTO) {
        Company company = CompanyDTOMapper.toEntity(requestDTO);
        return CompanyDTOMapper.toDTO(companyRepo.save(company));
    }
}