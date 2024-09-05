package com.ss.mybatis.mapper;

import com.ss.mybatis.dto.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// 데이터베이스 접근하는 클래스
@Mapper     // sqlSession 정보를 가지고 온다.
@Repository
public interface ArticleMapper {

    List<Article> findArticles();

    int insertArticles(Article article);

    List<Article> selectDetail(int id);

    int updateArticles(Article article);
}
