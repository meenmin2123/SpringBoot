package com.ss.chatbot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글번호

    @Column //필드를 테이블컬럼과 매핑한다.
    private String title;
    private String content;

    //하나의 게시글에서 여러개의 댓글을 조회
    @OneToMany(mappedBy = "article" ,cascade = CascadeType.ALL)
    private List<Comment> comments;
    //게시글에 달린 댓글 리스트를 만든다.

}
