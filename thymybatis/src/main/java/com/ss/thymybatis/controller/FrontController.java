package com.ss.thymybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.thymybatis.dto.BookDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FrontController {

	//뷰페이지로 이동하는 역할을 하는 컨트롤러
	@GetMapping("/form1")
	public String formPage() {
		return "post/form1";
	}
	
	@GetMapping("/form2")
	public String formPage2(Model model) {
		
		
		model.addAttribute("bookDTO",
						 new BookDTO());
		
		return "post/form2";
	}
	
}
