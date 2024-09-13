package com.ss.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectDemo {

    // 중복되는 로깅값을 모아놓는 advice 메서드 생성
    // @Before(target)
    // - target : 어떤 컨트롤러, 어떤 서비스가 실행될 때 사용을 할 것인지 패키지명을 작성

    // 하나의 컨트롤러 실행할 때 사용
    @Before("target(com.ss.board.controller.AopMainController)")
    public void advice1() {
        System.out.println("AspectDemo/advice1 - 메인 페이지 실행!");

        // 핵심 기능 - 조회, 출금, 입금 등 실행
    }

    @After("target(com.ss.board.controller.AopMainController)")
    public void advice2() {
        System.out.println("AspectDemo/advice2 - 메인 페이지 끝!");
    }

    // 컨트롤러 폴더에 있는 모든 클래스에 적용
    // - (..) : 매개변수의 타입ㅇ이나 개수를 신경쓰지 않음
    // -execution(접근제한자 반환타입 패키지이름.클래스이름.메서드이름(매개변수)) : AOP에서 포인트 컷. / 어떤 메서드에 대해 aop를 적용할 지 결정
    @Before("execution(* com.ss.board.controller..*(..))")
    public void pageMain() {
        System.out.println("AspectDemo/pageMain - 메인 페이지 실행!");

        // 핵심 기능 - 조회, 출금, 입금 등 실행
    }
}
