package com.ss.thymybatis.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article {
    private Long id;
    private String title;
    private String content;
    private Timestamp create_at;
}
