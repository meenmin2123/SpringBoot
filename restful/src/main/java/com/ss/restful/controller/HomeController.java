package com.ss.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/index.do")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/member/main.do")
	public String memberMain() {
		
		return "member/main";
	}
}
