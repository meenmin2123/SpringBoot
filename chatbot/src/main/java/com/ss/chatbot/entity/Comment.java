package com.ss.chatbot.entity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Comment {
    private int id;
    private String content;
    private String author;
    private String date;

    @JoinColumn(name="post_id")
    @ManyToOne(fetch = FetchType.LAZY) // 또는 @OneToOne
    private Post post;

}
