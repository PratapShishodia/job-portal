package com.ps.backend.repository;

import com.ps.backend.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    Page<Users> findAllByRole(Pageable pageable,String role);
    Optional<Users> findByUserEmail(String email);
}
