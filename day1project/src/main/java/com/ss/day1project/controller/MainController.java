package com.ss.day1project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.day1project.dto.User;

@Controller
public class MainController {
	// 브라우저에서 url "hi라는 요청이 들어옴

	@GetMapping("hi")
	public String hi(Model model) {
		System.out.println("MainController-hi()");
		// Model 인터페이스 객체에 addAttriubute

		model.addAttribute("username", "강만두");

		// 뷰 페이지 이름
		return "hi";
	}

	@GetMapping("/main.do")
	public String mainPage(Model model) {
		System.out.println("MainController-mainPage()");

		model.addAttribute("nickname", "abcd");

		return "main";
	}

	@GetMapping("/list.do")
	public String list(Model model) {
		System.out.println("MainController-list()");

		List<String> items = Arrays.asList("딸기", "복숭아", "포도");

		model.addAttribute("items", items);

		return "list";
	}

	@GetMapping("/object.do")
	public String objectPage(Model model) {
		System.out.println("MainController-list()");

		User user = new User();
		user.setId("qwer");
		user.setEmail("qwer@g.com");
		
		return "objList";
	}
	
	@GetMapping("/objList.do")
	public String objList(Model model) {
		
		List<User> users = new ArrayList<User>();
		users.add(new User("Alice", "alice@example.com"));
		users.add(new User("Bob", "bob@example.com"));
		users.add(new User("Charlie", "charlie@example.com"));
		users.add(new User("David", "david@example.com"));
		users.add(new User("Eve", "eve@example.com"));
		
		System.out.println("users : " + users);
		model.addAttribute("users",users);
		
		return "objList";
	}

}

/*
 * Mustache 템플릿 spring boot에서 컨트롤러에서 데이터를 전달 Mustache이 받아서 데이터를 웹 페이지에 출력하는 기본적인
 * 방법
 */