package com.ss.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AopMainController {

    // 메인 페이지 실행
    @GetMapping("/aop")
    public String aopMain() {
        log.info("AopMainController-aopMain()");

        return "aop/aopMainpage";
    }

    @GetMapping("/aop2")
    public String aopMain2() {
        log.info("AopMainController-aopMain2()");

        return "aop/aopMainpage2";
    }

    // 동시에 실행할 수 있는 around()
    @GetMapping("/aopAround")
    public String aopAround() {
        log.info("AopMainController-aopAround()");

        // 핵심 기능 추가
        log.info("동시에 실행");
        log.info("board 게시글 조회");

        return "aop/aopMainpage";
    }




}


