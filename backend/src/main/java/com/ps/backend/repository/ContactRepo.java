package com.ps.backend.repository;

import com.ps.backend.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepo extends JpaRepository<Contact,Long> {
    Page<Contact> findAllByUserEmail(Pageable pageable, String email);
}
