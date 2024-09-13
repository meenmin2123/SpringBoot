package com.ss.board.controller;

import com.ss.board.service.NaverApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
public class NaverAPIController {

    @Autowired
    private NaverApiService naverApiService;

    @GetMapping("/test/naverapi")
    public String naverapi(Model model) {
        log.info("naverapi");
        // 네이버 서비스 실행
        model.addAttribute("naver",naverApiService.getSummary());
        model.addAttribute("news",naverApiService.getCrawling());

        return "naver/summary";
    }
}
