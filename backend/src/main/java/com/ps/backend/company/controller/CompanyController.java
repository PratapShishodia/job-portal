package com.ps.backend.company.controller;

import com.ps.backend.company.service.CompanyService;
import com.ps.backend.dto.commonDTO.PageResponseDTO;
import com.ps.backend.dto.companyDTO.CompanyRequestDTO;
import com.ps.backend.dto.companyDTO.CompanyResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<PageResponseDTO<CompanyResponseDTO>> getAllCompanies(@RequestParam(defaultValue = "0", required =
            false) int page_num, @RequestParam(defaultValue = "10", required = false) int page_size,@RequestParam(defaultValue = "createdAt",required =false) String sort_by,@RequestParam(defaultValue = "desc",required = false) String direction) {
        return ResponseEntity.ok(companyService.getAllCompany(page_num, page_size, sort_by, direction));
    }

    @GetMapping("/{field}")
    public ResponseEntity<PageResponseDTO<CompanyResponseDTO>> getAllCompaniesbyField(@RequestParam(defaultValue = "0", required = false) int page_num, @RequestParam(defaultValue = "10", required = false) int page_size, @RequestParam(defaultValue = "createdAt",required =false) String sort_by, @RequestParam(defaultValue = "desc",required = false) String direction, @PathVariable String field) {
        return ResponseEntity.ok(companyService.getCompanyByField(page_num, page_size,sort_by,direction, field));
    }

//    @PostMapping
//    public ResponseEntity<List<CompanyResponseDTO>> addCompany(@RequestBody List<CompanyRequestDTO> companyDTO) {
//        List<CompanyResponseDTO> list = new ArrayList<>();
//        for (CompanyRequestDTO companyDTO1 : companyDTO) {
//            list.add(companyService.addCompany(companyDTO1));
//        }
//        return ResponseEntity.ok(list);
//    }
    @PostMapping
    public ResponseEntity<CompanyResponseDTO> addCompany(@RequestBody CompanyRequestDTO companyDTO){
        return ResponseEntity.ok(companyService.addCompany(companyDTO));
    }
}

