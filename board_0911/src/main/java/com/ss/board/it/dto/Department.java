package com.ss.board.it.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 부서에 대한 정보(부서명, 어떤 직원, 리스트)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private String deptName;
    private List<Employee> employees;

    // 어떤 직원들이 있는지 확인
    public void meeting() {
        System.out.println("** Employee Department ** ");
        System.out.println(deptName + " / "+ employees.toString());
    }
}
