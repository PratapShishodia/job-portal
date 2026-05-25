package com.ps.backend.job.controller;

import com.ps.backend.dto.JobRequestDTO;
import com.ps.backend.dto.JobResponseDTO;
import com.ps.backend.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/job")
public class JobController {

    private final JobService jobService;

    @GetMapping
    public ResponseEntity<List<JobResponseDTO>> getAllJobs(@RequestParam(required = false,defaultValue = "0") Integer page_num,
                                                           @RequestParam(required = false,defaultValue = "9") Integer page_size) {
        return ResponseEntity.ok(jobService.getJobs(page_num, page_size));
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<JobResponseDTO>> getJobsByCompanyId(@RequestParam(required = false,defaultValue = "0") Integer page_num,
                                                                   @RequestParam(required = false,defaultValue = "9") Integer page_size, @PathVariable long companyId) {
        return ResponseEntity.ok(jobService.getJobByCompanyId(page_num,page_size,companyId));
    }

    @GetMapping("/job")
    public ResponseEntity<JobResponseDTO> getJobById(@RequestParam(required = false) long jobId) {
        return ResponseEntity.ok(jobService.getJobByID(jobId));
    }

//    For Single entry
//    @PostMapping
//    public ResponseEntity<JobResponseDTO> saveJob(@RequestBody JobRequestDTO jobRequestDTO) {
//        return ResponseEntity.ok(jobService.createJob(jobRequestDTO));
//    }

//    for multiple
    @PostMapping
    public ResponseEntity<List<JobResponseDTO>> saveJob(@RequestBody List<JobRequestDTO> jobRequestDTO) {
        List<JobResponseDTO> responseDTOS = new ArrayList<>();
        for(JobRequestDTO jobRequestDTO1 : jobRequestDTO) {
            responseDTOS.add(jobService.createJob(jobRequestDTO1));
        }
        return ResponseEntity.ok(responseDTOS);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteJobById(@RequestParam long jobId) {
        return ResponseEntity.ok(jobService.deleteJob(jobId));
    }
}
