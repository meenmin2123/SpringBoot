package com.ss.thymeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//return 을 할 때 기본적으로 뷰페이지 파일명
// 파일명을 이용해서 뷰리졸버 경로 설정해서 뷰페이지로 이동!
@Controller
@Slf4j
public class HomeController {

    @GetMapping("/main.do")
    public String main(Model model) {
        log.info("HomeController-main() 실행");

        model.addAttribute("username","강만두");

        return "thymeleafEx1";
    }
}

/*
    * 타임리프
    - 자바 웹 어플리케이션 개발에 사용되는 서버 사이드 java 템플릿(부 화면 구성)
    - html, XML, 텍스트, 자바스크립트, css 다양하게 마크업 파일을 생성할 수 있음.
    - 동적인 뷰를 생성을 할 수 있음.
    - Natural Templating을 실행되지 않은 상태에서도 html 파일로서 자연스럽게 보여질 수 있음.
*/
