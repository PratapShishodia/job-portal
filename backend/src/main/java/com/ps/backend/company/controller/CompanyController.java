package com.ps.backend.company.controller;

import com.ps.backend.company.service.CompanyService;
import com.ps.backend.dto.CompanyRequestDTO;
import com.ps.backend.dto.CompanyResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyResponseDTO>> getAllDetails(@RequestParam(defaultValue = "0") int page_num,@RequestParam(defaultValue = "9") int page_size){
        return ResponseEntity.ok(companyService.getAllCompanies(page_num,page_size));
    }

    @GetMapping("/{field}")
    public ResponseEntity<List<CompanyResponseDTO>> getAllDetailsByField(@RequestParam(defaultValue = "0") int page_num, @RequestParam(defaultValue = "9") int page_size, @PathVariable String field){
        return ResponseEntity.ok(companyService.getAllCompaniesByField(page_num,page_size,field));
    }

//    Save All
    @PostMapping
    public ResponseEntity<List<CompanyResponseDTO>> addMultipleCompanies(@Valid @RequestBody List<CompanyRequestDTO> requestDTO){
        List<CompanyResponseDTO> companyResponseDTOList = new ArrayList<>();
        for(CompanyRequestDTO companyRequestDTO : requestDTO){
            companyResponseDTOList.add(companyService.addCompany(companyRequestDTO));
        }
        return ResponseEntity.ok(companyResponseDTOList);
    }
//    For Saving single
//    @PostMapping
//    public ResponseEntity<CompanyResponseDTO> addCompany(@Valid @RequestBody CompanyRequestDTO requestDTO){
//        return ResponseEntity.ok(companyService.addCompany(requestDTO));
//    }

}
