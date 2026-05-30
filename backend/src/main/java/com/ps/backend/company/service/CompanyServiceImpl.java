package com.ps.backend.company.service;

import com.ps.backend.dto.commonDTO.PageResponseDTO;
import com.ps.backend.dto.companyDTO.CompanyRequestDTO;
import com.ps.backend.dto.companyDTO.CompanyResponseDTO;
import com.ps.backend.entity.Company;
import com.ps.backend.enums.CompanyField;
import com.ps.backend.mapper.CompanyDTOMapper;
import com.ps.backend.repository.CompanyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepo companyRepo;

    public PageResponseDTO<CompanyResponseDTO> getCompanyByField(int page_num, int page_size, String sortBy, String sortdirc, String field) {
        Sort sort = sortdirc.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page_num, page_size,sort);
        Page<Company> companyPage = companyRepo.findAllByCompanyField(pageable, CompanyField.valueOf(field));
        List<CompanyResponseDTO> companyList = companyPage.getContent().stream().map(CompanyDTOMapper::toDTO).toList();
        PageResponseDTO<CompanyResponseDTO> response = new PageResponseDTO<>();
        response.setContent(companyList);
        response.setPageNumber(companyPage.getNumber());
        response.setPageSize(companyPage.getSize());
        response.setTotalElements(companyPage.getTotalElements());
        response.setTotalPages(companyPage.getTotalPages());
        response.setLastPage(companyPage.isLast());
        return response;
    }

    public PageResponseDTO<CompanyResponseDTO> getAllCompany(int page_num, int page_size, String sortBy, String sortdirc) {
        Sort sort = sortdirc.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page_num, page_size,sort);
        Page<Company> companyPage = companyRepo.findAllWithJobsByStatus(pageable);
        List<CompanyResponseDTO> companyList = companyPage.getContent().stream().map(CompanyDTOMapper::toDTO).toList();
        PageResponseDTO<CompanyResponseDTO> response = new PageResponseDTO<>();
        response.setContent(companyList);
        response.setPageNumber(companyPage.getNumber());
        response.setPageSize(companyPage.getSize());
        response.setTotalElements(companyPage.getTotalElements());
        response.setTotalPages(companyPage.getTotalPages());
        response.setLastPage(companyPage.isLast());
        return response;
    }

    @Transactional
    public CompanyResponseDTO addCompany(CompanyRequestDTO companyDTO) {
        if(companyRepo.existsByCompanyName(companyDTO.getCompanyName())){
            throw new RuntimeException("Company already exists");
        }
        Company company = CompanyDTOMapper.toEntity(companyDTO);
        return CompanyDTOMapper.toDTO(companyRepo.save(company));
    }

    @Transactional
    public CompanyResponseDTO updateCompany(long companyId, CompanyRequestDTO companyDTO) {
        Company company = companyRepo.findById(companyId).orElseThrow(() -> new RuntimeException("Company id not found"));
        if(companyRepo.existsByCompanyNameAndCompanyIdNot(company.getCompanyName(),companyId)){
            throw new RuntimeException("Company already exists");
        }
//        private String companyName;
        if(companyDTO.getCompanyName() != null){
            company.setCompanyName(companyDTO.getCompanyName());
        }
//        private String companyDesc;
        if(companyDTO.getCompanyDesc() != null){
            company.setCompanyDesc(companyDTO.getCompanyDesc());
        }
//        private String companyLogo;
        if(companyDTO.getCompanyLogo() != null){
            company.setCompanyLogo(companyDTO.getCompanyLogo());
        }
//        private CompanyField companyField;
        if(companyDTO.getCompanyField() != null){
            company.setCompanyField(companyDTO.getCompanyField());
        }
//        private int employeeCount;
        if(companyDTO.getEmployeeCount() != 0){
            company.setEmployeeCount(companyDTO.getEmployeeCount());
        }
//        private String size;
        if(companyDTO.getSize() != null){
            company.setSize(companyDTO.getSize());
        }
//        private int founded;
        if(companyDTO.getFounded() != 0){
            company.setFounded(companyDTO.getFounded());
        }
//        private String locations;
        if(companyDTO.getLocations() != null){
            company.setLocations(companyDTO.getLocations());
        }
        return CompanyDTOMapper.toDTO(companyRepo.save(company));
    }

    @Transactional
    public String deleteCompany(long companyId) {
        Company company = companyRepo.findById(companyId).orElseThrow(() -> new RuntimeException("Company id not found"));
        companyRepo.delete(company);
        return "Company deleted Successfully";
    }
}
