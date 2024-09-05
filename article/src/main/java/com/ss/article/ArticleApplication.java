package com.ss.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

}

/*
	* 서블릿 컨트롤러
	- 클라이언트 요청을 처리하고 결과를 반환하는 웹 프로그래밍 기술(자바)
	- 서블릿 컨테이너의 특징 : 서블릿 객체를 생성, 초기화, 호출, 종료 생명 주기를 관리함.
	- 서블릿 객체는 싱글톤 패턴으로 관리함.
	- 멀티스레딩을 지원함.
	
	* 컨트롤러 (프레젠테이션 계층)
	- HTTP 요청을 받아 비즈니스 계층으로 전송
	- 컨트롤러 : 프레젠테이션 계층을 실제 구현함.
	
	* 서비스 (비즈니스 계층)
	- 비즈니스 로직을 처리.
	
	* 리포지토리(퍼시스턴스 계층)
	- 데이터베이스 에 관란 로직 처리.
*/