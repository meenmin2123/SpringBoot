package com.ss.chatbot.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;         // 게시글 고유 번호
    private String title;   // 게시글 제목
}
