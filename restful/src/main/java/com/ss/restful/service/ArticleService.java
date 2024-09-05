package com.ss.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.restful.entity.Article;
import com.ss.restful.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleService {
	
	@Autowired
	private ArticleRepository repository;
	
	public List<Article> index(){
		log.info("RestController - index()");
		
		return repository.findAll();
	}
	
}
