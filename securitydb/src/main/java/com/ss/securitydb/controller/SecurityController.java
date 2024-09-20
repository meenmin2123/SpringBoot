package com.ss.securitydb.controller;

import com.ss.securitydb.entity.Users;
import com.ss.securitydb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class SecurityController {

    @Autowired
    private UserService userService;

    @GetMapping("/security")
    public String securityMain() {
        return "security/main";
    }

    @GetMapping("/security/sub")
    public String securitySub() {
        return "security/index";
    }

    @GetMapping("/security/admin")
    public String adminPage() {
        return "security/admin";
    }

    @GetMapping("/security/user")
    public String userPage() {
        return "security/user";
    }

    @GetMapping("/join")
    public String joinPage(Model model) {

        // 타임리프를 이용해서 object 속성이 붙으면 실제 뷰 페이지를 보여주는
        //  get 요청에서는 User 객체를 생성해서 model에 담아서 보내줘야 ㄴ함.
        model.addAttribute("users", new Users());
        return "security/join"; // 회원가입 페이지로 이동
    }

    @PostMapping("/register")
    public String joinPagePro(Users users, @RequestParam("role") String role) {
        log.info("SecurityController - joinPagePro()");

        userService.joinUserwirhRole(users,role);
        return "redirect:security/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "security/login"; // 로그인 페이지로 이동
    }

    @PostMapping("/loginPro")
    public String loginPagePro() {
        return "security/login";
    }
}
