package com.ss.board.it.controller;

import com.ss.board.it.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ItController {

    @Autowired
    private Employee employee;

    @GetMapping("/it/index")
    public String index() {
        System.out.println("employee : " + employee);
        
        employee.setName("만두");
        employee.setDepartment("개발팀");
        employee.work();
//        Employee emp = new Employee("강만두","개발팀");
//        emp.work();


        return "aop/index";
    }
}
