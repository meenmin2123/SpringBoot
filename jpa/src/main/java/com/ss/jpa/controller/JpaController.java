package com.ss.jpa.controller;

import com.ss.jpa.entity.Member;
import com.ss.jpa.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@Slf4j
public class JpaController {

    @Autowired
    private MemberRepository re;

    @GetMapping("/jpa")
    public String jpa(Model model) {

        System.out.println("main 메서드 실행");
        String name = "아이유";
        // List<Member> members = re.findByName(name);
        List<Member> members = re.findAll();

//        log.info(members+"");
        System.out.println(members + "");

        model.addAttribute("members", members);

        return "main";
    }

    @GetMapping()
    public String list(Model model) {

        System.out.println("list 메서드 실행");

        LocalDateTime startDate = LocalDateTime.parse("2023-01-01T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse("2023-12-01T00:00:00");
        String findName = "아이유";

        List<Member> members = re.findByCreateAtAfterAndName(startDate,endDate,findName);

        model.addAttribute("members", members);
        return "main";
    }
}
