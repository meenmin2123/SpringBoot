package com.ss.thymybatis.service;

import com.ss.thymybatis.dto.Article;
import com.ss.thymybatis.dto.Comment;
import com.ss.thymybatis.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper mapper;

    public List<Article> findAll(){
        return mapper.findAll();
    }

    public Article findListById(Long id) {
        return mapper.findListById(id);
    }

    public boolean insert(Article article) {
        return mapper.insert(article);
    }

    public boolean update(Article article) {
        return mapper.update(article);
    }

    public void insertComment(Comment comment) {
        mapper.insertComment(comment);
    }

    // 댓글리스트 가져오기
    public List<Comment> commentList (int articleId) {
        return mapper.commetList(articleId);
    }

    public Comment commentUpdate(Comment comment) {
        return mapper.commentUpdate(comment);
    }

    public Comment commentDelete(int id) {
        return mapper.commentDelete(id);
    }
}
