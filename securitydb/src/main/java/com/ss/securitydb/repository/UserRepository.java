package com.ss.securitydb.repository;

import com.ss.securitydb.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {

    Users findById(Long id);
    Users findByUsername(String name);
    Users findByEmail(String email);
}
