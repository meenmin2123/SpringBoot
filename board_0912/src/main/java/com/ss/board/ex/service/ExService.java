package com.ss.board.ex.service;

import com.ss.board.it.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExService {

    public List<Object> deSomeMethod(String input, int num) {
        System.out.println("ExService-deSomeMethod()");
        System.out.println("input 처리 내용 : " + input);
        System.out.println("input 처리 내용 : " + num);

        List<Object> list = new ArrayList<Object>();
        list.add(input);
        list.add(num);

        return list;
    }

    public Employee doEmpMethod(Employee employee) {
        System.out.println("ExService-doEmpMethod()");
        System.out.println("input 처리 내용 : " + employee);
        System.out.println("* name : " + employee.getName());
        System.out.println("* dept : " + employee.getDepartment());

        return employee;
    }
}
