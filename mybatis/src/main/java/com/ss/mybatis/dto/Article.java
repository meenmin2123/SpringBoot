package com.ss.mybatis.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Article {

    private Long id;

    @NonNull
    private String title;
    @NonNull
    private String content;
}
