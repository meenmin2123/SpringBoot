package com.ss.board.it.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// 직원의 정보를 저장하는 클래스
// new Employee()로 직접 작성을 하게 되면 spring boot에서 beans를 관리하지 않기
// 때문에 aop가 적용이 안 됨.
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Component
public class Employee {
    private String name;
    private String department;

    // 추가 메서드
    public void work() {
        System.out.println("** Employee works ** ");
        System.out.println(name + " / 부서 : "+ department);
    }
}
