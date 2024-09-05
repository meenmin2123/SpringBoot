package com.ss.mybatis.service;

import com.ss.mybatis.dto.Article;
import com.ss.mybatis.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper mapper;

    public List<Article> index(){
        return mapper.findArticles();
    }

    public int insert(Article article) {
        return mapper.insertArticles(article);
    }

    public List<Article> selectDetail(int id) {
        return mapper.selectDetail(id);
    }

    public int update(Article article) {
        return mapper.updateArticles(article);
    }
}
