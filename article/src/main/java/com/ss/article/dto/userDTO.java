package com.ss.article.dto;

import com.ss.article.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userDTO {
	
	private String id;
	private String name;
	private int birth;
	private String phone;
	
	public User toEntity() {
		return new User(id, name, birth, phone);
	}
	

}
