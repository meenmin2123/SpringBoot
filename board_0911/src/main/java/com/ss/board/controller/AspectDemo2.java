package com.ss.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectDemo2 {

    // 앞과 뒤에 실행되는 메서드를 동시에 실행 -> @Around
    // 메서드 실행 전후 모두에서 작업을 수행할 수 있는 유일한 advice
    //  - advice : 실제 부가적인 기능을 구현한 객체
    @Around("execution(* com.ss.board.controller.AopMainController.aopMain(..))")
    public Object aopAroundMain(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AOP Main Method");

        // 처음 실행될 때 시작하는 명령문 작성
        System.out.println("Before Method 실행");

        // 핵심 메서드를 실행하는 부분
        // ProceedingJoinPoint() : 타켓메서드에 접근하고 실행할 수 있는 인터페이스
        // - 메서드의 인자 정보, 메서드 이름, 클래스 정보 결과값을 리턴할 수 있도록 함.
        // - 타켓 메서드들의 타입이 다 다를 수 있음. -> Object 타입으로 전환
        Object result = joinPoint.proceed();
        System.out.println("결과 : " + result.toString());
        System.out.println("Signature : " + joinPoint.getSignature());
        System.out.println("Target : " + joinPoint.getTarget());

        // 나중에 실행될 때 시작하는 명령문 작성
        System.out.println("After Method 실행");

        return "";
    }


    // 각각 메서드에 정의해서 다른 내용을 출력할 수 있음.
//    @Before("execution(String com.ss.board.controller.AopMainController.aopMain(..))")

    @Before("execution(* com.ss.board.controller.AopMainController.aopMain(..))")
    public void aopPage() {
        System.out.println("AspectDemo2/aopPage - 빵또아 메인 페이지 실행!");

        // 핵심 기능 - 조회, 출금, 입금 등 실행
    }

    @Before("execution(* com.ss.board.controller.AopMainController.aopMain2(..))")
    public void aopPage2() {
        System.out.println("AspectDemo2/aopPage2 - 메인 페이지 실행!");

        // 핵심 기능 - 조회, 출금, 입금 등 실행
    }

}
