package com.ps.backend.repository;

import com.ps.backend.entity.Company;
import com.ps.backend.enums.CompanyField;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
    Page<Company> findAllByCompanyField(Pageable pageable, CompanyField companyField);
}
