package com.ps.backend.job.controller;

import com.ps.backend.company.service.CompanyService;
import com.ps.backend.dto.commonDTO.PageResponseDTO;
import com.ps.backend.dto.jobDTO.JobRequestDTO;
import com.ps.backend.dto.jobDTO.JobResponseDTO;
import com.ps.backend.job.service.JobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<PageResponseDTO<JobResponseDTO>> getAllJobs(@RequestParam(defaultValue = "0", required = false) int page_num, @RequestParam(defaultValue = "10", required = false) int page_size, @RequestParam(defaultValue = "createdAt",required =false) String sort_by, @RequestParam(defaultValue = "desc",required = false) String direction) {
        return ResponseEntity.ok(jobService.getAllJobs(page_num, page_size,sort_by,direction));
    }
    @GetMapping("/{companyId}")
    public ResponseEntity<PageResponseDTO<JobResponseDTO>> getAllJobsByCompany(@RequestParam(defaultValue = "0", required = false) int page_num, @RequestParam(defaultValue = "10", required = false) int page_size,@RequestParam(defaultValue = "createdAt",required =false) String sort_by, @RequestParam(defaultValue = "desc",required = false) String direction, @PathVariable long companyId) {
        return ResponseEntity.ok(jobService.getAllJobsByCompanyID(page_num, page_size,sort_by,direction, companyId));
    }

//    @PostMapping
//    public ResponseEntity<JobResponseDTO> createJob(@Valid @RequestBody JobRequestDTO jobRequestDTO) {
//        return ResponseEntity.ok(jobService.addJob(jobRequestDTO));
//    }

    @PostMapping
    public ResponseEntity<List<JobResponseDTO>> createJob(@Valid @RequestBody List<JobRequestDTO> jobRequestDTO) {
        List<JobResponseDTO> jobResponseDTOList = new ArrayList<>();
        for (JobRequestDTO jobRequestDTO1 : jobRequestDTO) {
            jobResponseDTOList.add(jobService.addJob(jobRequestDTO1));
        }
        return ResponseEntity.ok(jobResponseDTOList);
    }
}
