package com.ss.junit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MyController {

    @GetMapping("/test")
    public String test() {
        log.info("MyController - test() 실행");
//        return "main/testPage";
        return "!!Hello world!!";
    }

    // ResponseEntity<?>
//    @PostMapping("/create")
//    public ResponseEntity<String> create() {
//        log.info("MyController - create() 실행");
//
//        return ResponseEntity.ok("created");
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> update(@PathVariable Long id) {
//        log.info("MyController - update() 실행");
//
//        return ResponseEntity.ok("update!");
//    }
}

// MockMVC : 웹 컨트롤러의 서버를 실행하지 않고 테스트할 수 있도록 도와주는 라이브러리
// - 통합 테스트, 컨트롤러 테스트할 때 유용하게 사용됨.