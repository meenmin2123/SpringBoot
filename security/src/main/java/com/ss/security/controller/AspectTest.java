package com.ss.security.controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {

    @Before("execution(* com.ss.security.controller.IndexController.*(..))")
    public void aspectBefore() {
        System.out.println("[aspect before]");
    }

    @After("execution(* com.ss.security.controller.IndexController.*(..))")
    public void aspectAfter() {
        System.out.println("[aspect after]");
    }
}
