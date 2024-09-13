package com.ss.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MemberController {

    @GetMapping("/login")
    public String login() {
        log.info("MemberController-login()");

        return "login/loginPage";
    }

    // --------------------------------------------------

    @GetMapping("/member")
    public String memberMain() {
        log.info("MemberController-memberMain()");

        return "aop/aopMainpage";
    }

    @GetMapping("/member2")
    public String memberMain2() {
        log.info("MemberController-memberMain2()");

        return "aop/aopMainpage";
    }
}
