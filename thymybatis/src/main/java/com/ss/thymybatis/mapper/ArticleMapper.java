package com.ss.thymybatis.mapper;

import com.ss.thymybatis.dto.Article;
import com.ss.thymybatis.dto.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    //전체조회
    List<Article> findAll();

    //한 건 조회
    Article findListById(Long id);

    // 게시글 수정
    boolean update(Article article);

    boolean insert(Article article);

    // 댓글 추가
    void insertComment(Comment comment);

    // 댓글 리스트 가져오기
    List<Comment> commetList(int articleId);

    // 댓글 수정 후 반환 타입 생성
    Comment commentUpdate(Comment comment);

    Comment commentUpdateNew(int id);

    Comment commentDelete(int id);
}
