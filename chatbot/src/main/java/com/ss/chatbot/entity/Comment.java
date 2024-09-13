package com.ss.chatbot.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 댓글번호

    @Column
    private String nickname;

    @Column
    private String body;


    // 댓글이 속한 게시글과 관계
    // 다대일
    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;

}
