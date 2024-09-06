package com.ss.thymybatis.articlecontroller;

import com.ss.thymybatis.dto.Comment;
import com.ss.thymybatis.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ArticleRestController {

    @Autowired
    private ArticleService service;

    // 기본 매핑을 할 때(수정할 때)는 PatchMapping("/comment/{id}")
    // mapping (method="Patch")
    @PatchMapping()
    public ResponseEntity<Comment> updateComment(@PathVariable int id, @RequestBody Comment comment) {
        log.info("ArticleRestController-updateComment");

        log.info("id : "+ id);
        log.info("comment : "+comment);

        Comment updated = service.commentUpdate(comment);

        return updated != null ? ResponseEntity.status(HttpStatus.OK).body(updated) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // 댓글 삭제를 요청하는 mapping (method="delete")
    @DeleteMapping()
    public ResponseEntity<Comment> deleteComment(@PathVariable int id) {
        log.info("ArticleRestController-deleteComment");

        Comment deleted = service.commentDelete(id);

        return deleted != null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
