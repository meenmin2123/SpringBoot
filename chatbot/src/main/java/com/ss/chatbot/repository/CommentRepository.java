package com.ss.chatbot.repository;

import com.ss.chatbot.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    //특정 게시글의 모든 댓글을 조회하는 메서드
    //@Query() 쿼리를 만들어 사용할 수 있다.

    @Query(value="select * from comment where article_id=1", nativeQuery = true)
    List<Comment> findByArticleId (Long articleId);
}
