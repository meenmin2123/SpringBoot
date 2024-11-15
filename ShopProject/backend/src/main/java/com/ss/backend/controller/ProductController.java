package com.ss.backend.controller;

import com.ss.backend.entity.Member;
import com.ss.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Member member) {

        memberService.register(member);
        return ResponseEntity.ok("회원가입");
    }

    @PostMapping("/login")
    public String login(@RequestBody Member member) {
        System.out.println("member:" + member);

        try {
            // 비밀번호랑 이메일을 인증
            // authenticate(null) 사용자가 입력한 이메일과 비밀번호가 맞는지 확인하는 메서드
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(member.getEmail(), member.getPassword()));

            System.out.println("인증시도: " + authentication);
            System.out.println("비밀번호:" + authentication.getCredentials());
            System.out.println("인증여부: " + authentication.isAuthenticated());
            System.out.println("권한:" + authentication.getAuthorities());
            // 인증 성공 시
            if (authentication.isAuthenticated()) {
                return "로그인 성공!";
            } else {
                return "로그인 실패!";
            }
        }catch(Exception e) {
            e.printStackTrace();
            return "로그인 실패!" + e.getMessage();
        }
    }
}
