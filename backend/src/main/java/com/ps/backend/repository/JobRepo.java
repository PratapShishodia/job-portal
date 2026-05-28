package com.ps.backend.repository;

import com.ps.backend.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<Job, Long> {
    Page<Job> findAllByCompany(Pageable pageable, long companyId);
    Page<Job> findByCompanyCompanyId(Pageable pageable, long companyId);
}
