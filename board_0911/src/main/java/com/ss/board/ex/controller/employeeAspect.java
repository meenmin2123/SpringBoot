package com.ss.board.ex.controller;

import com.ss.board.it.dto.Employee;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class employeeAspect {

    @Before("execution(* com.ss.board.ex.service.ExService.doEmpMethod(..)) && args(emp)")
    public void empInfo(Employee emp) {
        System.out.println("employeeAspect-empInfo()");
        System.out.println("aspect 전송 : " + emp);
    }
}
