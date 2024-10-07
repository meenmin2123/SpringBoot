package com.ss.facebook.controller;

import com.ss.facebook.service.FacebookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private FacebookService facebookService;

    @GetMapping("index")
    public String index() {
        return "index";
    }


}
