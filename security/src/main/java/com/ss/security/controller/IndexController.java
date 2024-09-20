package com.ss.security.controller;

import com.ss.security.entity.Users;
import com.ss.security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    public String index() {
        log.info("IndexController-index()");

        return "main/memberlistPage";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        log.info("IndexController-user()");

        return "main/userPage";
    }

    // 메서드에서 접근 권한을 설정

    @Secured("ROLE_MANAGER")

    // 메서드 실행 전에 권한 설정
    @PreAuthorize("hasRole('ROLE_MANAGER')")

    // 메서드 실행 후에 권한 설정
    @PostAuthorize("hasRole('ROLE_MANAGER')")
    @GetMapping("/manager")
    @ResponseBody
    public String manager() {
        log.info("IndexController-manager()");

        return "main/managerPage";
    }
    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        log.info("IndexController-admin()");

        return "main/managerPage";
    }

    @GetMapping("/login.do")
    public String login() {
        log.info("IndexController-login()");

        return "login/loginPage";
    }

    @PostMapping("/loginPro")
    public String loginPro(Users user) {
        log.info("IndexController-loginPro()");
        log.info("로그인 : " + user);

        return "redirect:/index";
    }

    @GetMapping("/join")
    public String join() {
        log.info("IndexController-join()");

        return "main/joinPage";
    }

    @PostMapping("/joinPro")
    public String joinPro(Users user) {
        log.info("IndexController-joinPro()");
        log.info("회원가입 진행 : " + user);

        // 입력받은 비밀번호를 먼저 꺼냄
        String inputPw = user.getPassword();

        // 암호화
        String encPw = encoder.encode(inputPw);

        System.out.println("암호화 진행 PW : " + encPw);

        // 비밀번호 저장
        user.setPassword(encPw);

        // 권한 부여
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return "redirect:/index";
    }
}
