package com.ss.board.it.controller;

import com.ss.board.it.dto.Employee;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class FingerprintAdvice {

    private List<String> namelist = new ArrayList<>();

    // 아침에 지문인증을 할 수 있도록
    // execution() : 어디 메서드를 가로챌 것인지 결정하는 부분
    // within() : 클래스 내부에 속한 메서드에만 Advice가 적용될 수 있도록 범위를 제한하는 메서드
    @Before("execution(* com.ss.board.it.dto.Employee.work(..)) && target(em) && within(com.ss.board.it.dto.Department)")
    public void fingerCheck(Employee em) {
        System.out.println(em.getName() + "출근 지문 인식 성공!");
    }
//    @Before("execution(* com.ss.board.it.dto.Employee.work(..))")
//    public void fingerCheck() {
//        System.out.println("출근 지문 인식 성공!");
//    }

//    @After("execution(* com.ss.board.it.dto.Employee.work(..)) && target(em)")
//    public void fingerCheckOk(Employee em) {
//        System.out.println(em.getName() +"출근 지문 인식 성공!!!!!");
//    }

    @After("execution(* com.ss.board.it.dto.Employee.work(..)) && target(em)")
    public void taxiCheck(Employee em) {

        // 1시간 이상 되는 직원들의 정보를 받아야함.
        if(isTaxi(em)) {
            System.out.println(em.getName() +" : 택시비 지원 대상");
            namelist.add(em.getName());
        } else {
            System.out.println(em.getName() +" : 택시비 지원 대상 아님");
        }
    }

    boolean isTaxi(Employee em) {

        boolean res = false;

        for(String name : namelist) {
            if(em.getName().equals(name)) {
                res = true;
            }
        }

        return res;
    }
}
