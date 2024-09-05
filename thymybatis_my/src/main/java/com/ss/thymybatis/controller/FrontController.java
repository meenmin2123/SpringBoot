package com.ss.thymybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class FrontController {

    // 뷰 페이지로 이동하는 역할을 하는 Controller
    @GetMapping("/form1.do")
    public String formPage() {
        log.info("FrontController-formPage");
        return "thymeleaf/post/form";
    }
}
