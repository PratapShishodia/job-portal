package com.ps.backend.jobApplication.controller;

import com.ps.backend.company.service.CompanyService;
import com.ps.backend.dto.commonDTO.PageResponseDTO;
import com.ps.backend.dto.jobApplicationDTO.JobApplicationRequestDTO;
import com.ps.backend.dto.jobApplicationDTO.JobApplicationResponseDTO;
import com.ps.backend.jobApplication.service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobApplication")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<PageResponseDTO<JobApplicationResponseDTO>> findAll(@RequestParam(required = false,defaultValue = "0") int page_num, @RequestParam(required = false,defaultValue = "10") int page_size,@RequestParam(defaultValue = "createdAt",required =false) String sort_by, @RequestParam(defaultValue = "desc",required = false) String direction) {
        return ResponseEntity.ok(jobApplicationService.getAllJobsApplication(page_num, page_size,sort_by,direction));
    }

    @GetMapping("/{applicationId}")
    public ResponseEntity<JobApplicationResponseDTO> getJobByApplicationID(@PathVariable long applicationId) {
        return ResponseEntity.ok(jobApplicationService.getJobByID(applicationId));
    }

    @PostMapping
    public ResponseEntity<JobApplicationResponseDTO> saveJob(@RequestBody JobApplicationRequestDTO jobApplicationRequestDTO) {
        return ResponseEntity.ok(jobApplicationService.addJob(jobApplicationRequestDTO));
    }

//    @PostMapping
//    public ResponseEntity<List<JobApplicationResponseDTO>> saveJob(@RequestBody List<JobApplicationRequestDTO> jobApplicationRequestDTO) {
//        List<JobApplicationResponseDTO> jobApplicationResponseDTOList = new ArrayList<>();
//        for (JobApplicationRequestDTO jobApplicationRequestDTO1 : jobApplicationRequestDTO) {
//            jobApplicationResponseDTOList.add(jobApplicationService.addJob(jobApplicationRequestDTO1));
//        }
//        return ResponseEntity.ok(jobApplicationResponseDTOList);
//    }
}
