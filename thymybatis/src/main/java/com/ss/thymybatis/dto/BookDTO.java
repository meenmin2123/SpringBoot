package com.ss.thymybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {

	private long idx;
	private String title;
	private String author;
	private String publisher;
	private String publisherDate;
	
}
