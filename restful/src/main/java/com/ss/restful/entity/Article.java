package com.ss.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// MySQL
															// 오라클 - GenerationType.SEQUENCE
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String content;

}

// @Entity : 어노테이션이 붙은 클래스 이름으로 spring boot 자동으로 테이블을 생성함.
