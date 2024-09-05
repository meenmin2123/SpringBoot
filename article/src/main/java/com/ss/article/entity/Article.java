package com.ss.article.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/*
	* JPA : 객체 관계 매핑 기술의 표준으로 인터페이스 모음
		- java 애플리케이션과 JDBC 사이에 등작함.
		- 자바에서 SQL를 DB로 전달하고 결과를 반환 받을 때 사용함.

	# JPA 자동으로 테이블도 생성하고 SQL을 보낼 떄 그때 어노테이션 @Entity 붙은 클래스를 
	JPA가 각 필드의 어노테이션을 보고 DB 테이블과 매핑해 관리해줌.
*/

// Entity로 사용되는 클래스 표시
// 조건 Entity로 사용할 클래스에는 기본 생성자는 무조건 설정해야함. (아님 에러 발생)
@Entity	
@NoArgsConstructor
@AllArgsConstructor
public class Article {
	
	// 기본키랑 필드(컬럼)
	@Id		// 필드 생성, 기본키 설정
	//@GeneratedValue		// 기본키 값을 자동으로 생성. 시퀀스가 무조건 1부터 시작.
	@GeneratedValue	(strategy = GenerationType.IDENTITY)  // 시퀀스가 입력된 데이터 개수 다음부터 시작함.
	private Long id;
	
	@Column	// 필드를 테이블 컬럼명과 매핑함.
	private String title;
	
	@Column
	private String content;

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
