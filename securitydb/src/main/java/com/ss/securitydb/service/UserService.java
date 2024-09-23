package com.ss.securitydb.service;

import com.ss.securitydb.entity.Role;
import com.ss.securitydb.entity.Users;
import com.ss.securitydb.repository.RoleRepository;
import com.ss.securitydb.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // 회원가입
    public void joinUserwirhRole(Users users, String role) {
        log.info("UserService - joinUserwirhRole()");

        // 1. 비밀번호 암호화하여 사용자 비밀번호 저장
        users.setPassword(passwordEncoder.encode(users.getPassword()));

        // 2. 사용자 정보 저장
        userRepository.save(users);

        // 3. 선택한 역할에 따라 admin -> ROLE_ADMIN 저장
        Role userRole = new Role();
        userRole.setRoleName(role);
        userRole.setUsername(users.getUsername());

        // 테이블끼리 연결

        if ((role.equals("ADMIN"))) {
            userRole.setRoleName("ROLE_ADMIN");
        } else {
            userRole.setRoleName("ROLE_USER");
        }

        // 4. roole 디비에 저장
        roleRepository.save(userRole);
    }

    // username으로 조회하는 메서드

    // DB에 저장된 암호화된 비밀번호와 비교하는  메서드
    // 첫번째 매개변수 : 비밀번호는 이미 암호화
    public boolean checkPassword(Users users, String password) {
        log.info("UserService - checkPassword()");

        // 로그인 할 때 입력한 비밀번호를 암호화하여
        // 데이터베이스에 저장된 비밀번호를 비교해서 같으면 true, 다르면 false
        return passwordEncoder.matches(password, users.getPassword());
    }

    // Role을 조회하는 메서드
    public boolean checkRole(String name, String role) {
        log.info("UserService - checkRole()");

        boolean result = false;

        // 1. 사용자 정보를 가져오는 것
        Users user = userRepository.findByUsername(name);

        // 2. 해당 사용자의 역할 목록을 반복하면서 특정 역할이 있는지 확인
        for(Role r : user.getRoles()) {
            if(r.getRoleName().equals(role)) {
                result = true;
                return result;
            }
        }

        // 권한을 없을 경우, false 반환
        return result;
    }

    public Users findById(Long id) {
        return userRepository.findById(id);
    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

/*
* [ 자바 스트림 API ]
* - user.getRoles().strame().anyMatch(r -> r.getRole().equals(role))
*
* */
