package com.ss.restful.dto;

import com.ss.restful.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleDTO {

	private Long id;
	private String title;
	private String content;
	
	// DTO에서 데이터베이스랑 매핑을 할 수 있도록 Entity로 변환하는 메서드가 필요함.
	public Article toEntity() {
		return new Article(id, title, content);
	}

}