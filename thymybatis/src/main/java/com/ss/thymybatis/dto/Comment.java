package com.ss.thymybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
	private int id;    			// 댓글번호
	private String nickname; 	// 닉네임
	private String body;    	// 내용
	private long articeId;    	// 글번호

	public void setArticleId(Long id) {
	}
}
