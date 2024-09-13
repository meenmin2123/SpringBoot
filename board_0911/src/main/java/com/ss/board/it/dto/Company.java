package com.ss.board.it.dto;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Department> departments;

    public Company() {
        this.departments = new ArrayList<Department>();
    }
    public void callForMeeting(String name) {
        
        for (Department department : departments) {
            if(name.equals(department.getDeptName())) {
                System.out.println(department.getDeptName());
            }
        }
        
        // 추가 작업을 해야되는 대상 => 타켓
        // 타멧에 적용하고 싶은 작업 => Advice
        // 해야될 일 ex) 지문인증
        // 구체적인 위치를 지정(조인 포인트)
        // 실제 추가작업을 하는 행위를 관섭, 위빙
        // 위에 실제 구성을 하기 위해서는 지문 인증 Advice 작성
        
    }
}
