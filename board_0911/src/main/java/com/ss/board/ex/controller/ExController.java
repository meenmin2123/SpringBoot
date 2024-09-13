package com.ss.board.ex.controller;

import com.ss.board.ex.service.ExService;
import com.ss.board.it.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class ExController {

    @Autowired
    private ExService service;

    @Autowired
    Employee employee;

    @GetMapping("/ex/index")
    public String exPage(Model model) {

        List<Object> list = service.deSomeMethod("HELLO WORLD!",30293472);
        model.addAttribute("list", list);

        return "aop/index";
    }

    @GetMapping("/ex/doEmp")
    public String doEmployee(Model model) {
        System.out.println("ExController-doEmployee()");

        employee.setName("강만두");
        employee.setDepartment("기획팀");

        Employee emp = service.doEmpMethod(employee);
        model.addAttribute("emp", emp);

        return "aop/index2";
    }
}
