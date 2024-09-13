package com.ss.security.repository;

import com.ss.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    // 회원가입 시 아이디 중복 확인
    Users findByUsername(String username);
//    @Query(value="SELECT * FROM USER", nativeQuery=true)
//    User findByEmail(String email);

    // 로그인 시
    Users findByUsernameAndPassword(String username, String password);
}
