package com.ss.backend.google;

import com.ss.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일 사용자 찾기
    User findByEmail(String email);
}
