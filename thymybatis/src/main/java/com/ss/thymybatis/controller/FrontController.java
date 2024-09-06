package com.ss.thymybatis.controller;

import com.ss.thymybatis.dto.Article;
import com.ss.thymybatis.dto.Comment;
import com.ss.thymybatis.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.thymybatis.dto.BookDTO;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class FrontController {

	@Autowired
	private ArticleService service;

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

	@GetMapping("/writePage")
	public String writePage(Model model) {
		log.info("FrontController-writePage()");

		model.addAttribute("article",new Article());
		return "article/writePage";
	}

	@GetMapping("/mainPage")
	public String mainPage(Model model) {
		log.info("FrontController-mainPage()");

		List<Article> articleList = service.findAll();

		model.addAttribute("articleList", articleList);
		return "article/mainListPage";
	}

	@GetMapping("/comment")
	public String comment(Model model) {
		log.info("comments()");


		// 댓글에 관련된 창을 띄울때 바인딩하는 객체가 없어서 에러!
		model.addAttribute("comment", new Comment());

		return "comment/comments";
	}
}
