package com.ss.securitydb.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    @Before("execution(* com.ss.securitydb.controller.SecurityController.*(..))")
    public void aspectBefore() {
        System.out.println("[AspectConfig before]");
    }

    @After("execution(* com.ss.securitydb.controller.SecurityController.*(..))")
    public void aspectAfter() {
        System.out.println("[AspectConfig after]");
    }
}
