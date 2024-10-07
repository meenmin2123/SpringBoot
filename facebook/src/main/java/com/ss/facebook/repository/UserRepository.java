package com.ss.facebook.repository;

import com.ss.facebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // 이메일로 검색
    User findByEmail(String email);
}
