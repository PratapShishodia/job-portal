package com.ps.backend.repository;

import com.ps.backend.entity.Company;
import com.ps.backend.enums.CompanyField;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
    @Query("select distinct c from Company c join fetch c.jobs j where j.status = 'ACTIVE'")
    Page<Company> findAllWithJobsByStatus(Pageable pageable);
    Page<Company> findAllByCompanyField(Pageable pageable, CompanyField companyField);
    boolean existsByCompanyName(String name);
    boolean existsByCompanyNameAndCompanyIdNot(String companyName, Long companyId);
}
