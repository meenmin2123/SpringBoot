package com.ss.article.dto;

import com.ss.article.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class articleDTO {
	
	// Id가 null로 들어가면 안됨.
	private Long id;
	private String title;
	private String content;
	
	// dto 클래스에서 데이터를 entity(테이블과 매핑되는 클래스)로 변환하는 메서드를 추가하는 것
	public Article toEntity() {
		return new Article(id, title, content);
	}
	
}
