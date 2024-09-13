package com.ss.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AccountController {

    @GetMapping("/account")
    public String accountMain() {
        log.info("AccountController-memberMain()");

        return "aop/aopMainpage";
    }
}
