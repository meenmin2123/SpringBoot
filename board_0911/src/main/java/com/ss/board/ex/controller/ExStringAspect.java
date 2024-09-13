package com.ss.board.ex.controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExStringAspect {

    // args(param)
    // - 특정 타입의 인자가 전달된 메서드에만 advice

    @Before("execution(* com.ss.board.ex.service.ExService.deSomeMethod(..)) && args(param)" )
    public void stringEx(String param) {
        System.out.println("aspect 전송 : " + param);
    }

    @After("execution(* com.ss.board.ex.service.ExService.deSomeMethod(..)) && args(param,num)" )
    public void stringEx2(String param, int num) {
        System.out.println("aspect 전송 : " + param);
        System.out.println("aspect 전송 : " + num);
    }
}
