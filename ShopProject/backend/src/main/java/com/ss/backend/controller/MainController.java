package com.ss.backend.controller;

import com.ss.backend.google.GoogleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private GoogleService googleService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        log.info("login");

        String googleUrl = googleService.getGoogleLogin();

        log.info("googleUrl : " + googleUrl);

        model.addAttribute("googleUrl",googleUrl);
        return "login";
    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "login-success"; // 로그인 성공 페이지로 이동
    }

    @GetMapping("/login-failure")
    public String loginFailure() {
        return "login-failure"; // 로그인 실패 페이지로 이동
    }


    // 구글에서 인가 코드가 정상적으로 왔는지 확인하는 리다이렉트 메서드
    @GetMapping("/google/auto")
    public String goolge(String code) {
        log.info("구글 인가 코드: {}",code);

        googleService.getGoogleInfo(code);

        return "login";
    }
}
