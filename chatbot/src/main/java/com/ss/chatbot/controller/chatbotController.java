package com.ss.chatbot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
