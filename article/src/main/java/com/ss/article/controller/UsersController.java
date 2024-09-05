package com.ss.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ss.article.dto.userDTO;
import com.ss.article.entity.Article;
import com.ss.article.entity.User;
import com.ss.article.repository.UserResitory;

import lombok.extern.slf4j.Slf4j;

@Controller
@ Slf4j	
public class UsersController {
	
	@Autowired
	private UserResitory articleSql;
	
	@GetMapping("/users/userPage")
	public String userPage() {
		
		return "users/userPage";
	}
	
	@PostMapping("/users/create")
	public String userCreate(Model model, userDTO dto) {
		
		log.info(" 정보를 출력하는 로그");
		log.info(dto.toString());
		System.out.println(dto);
		
		User user = dto.toEntity();
		log.info(user.toString());
		
		User result = articleSql.save(user);
		log.info("결과값 : " + result);
		
		return "users/userPage";
	}

}
