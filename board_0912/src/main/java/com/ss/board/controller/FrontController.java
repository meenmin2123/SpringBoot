package com.ss.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class FrontController {

    @GetMapping("/index")
    public String indexPage() {
        return "main/index";
    }
}
