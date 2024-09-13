package com.ss.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class chatbotController {

    @GetMapping("/main.do")
    public String mainPage() {
        return "main/main";
    }

    @GetMapping("/chatting.do")
    public String chattingPage() {
        return "main/chatting";
    }

    // ---
}
