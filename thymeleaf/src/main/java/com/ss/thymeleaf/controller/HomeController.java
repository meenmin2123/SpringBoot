package com.ss.thymeleaf.controller;

import com.ss.thymeleaf.dto.BookStore;
import com.ss.thymeleaf.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Book;
import java.util.*;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/main.do")
    public String model(Model model) {

        log.info("HomeController-model()실행!");

        model.addAttribute("username","강만두");

        return "thymeleafEx1";
        // classpath:templates/thymeleaf/thymeleafEx1.html
    }

    @GetMapping("/model1.do")
    public String model1(Model model) {

        log.info("HomeController-model1()실행!");

        // list 타입 넘기기
        List<String> items = Arrays.asList("spring","springboot","AWS");

        // Map 타입 넘기기
        Map<String, Object> scorelist = new HashMap<String, Object>();
        scorelist.put("만두", 100);
        scorelist.put("파인애플", 90);
        scorelist.put("샤인머스켓", 94);
        scorelist.put("사과", "기권");
        scorelist.put("딸기", 95);
        scorelist.put("수박", 94);

        // list & map
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        listmap.add(scorelist);

        model.addAttribute("listmap",listmap);
        model.addAttribute("scoremap",scorelist);
        model.addAttribute("list",items);
        model.addAttribute("num1",10);
        model.addAttribute("num2",50);
        model.addAttribute("person",new Person("강만두",10));

        return "thymeleafex2";
    }

    @GetMapping("/model2.do")
    public String model2(Model model) {

        log.info("HomeController-model2()실행!");

        model.addAttribute("isAdmin",true);
        model.addAttribute("age",20);
        model.addAttribute("role","user");
        model.addAttribute("role2","guest");
        model.addAttribute("person",new Person("강만두",10));
        model.addAttribute("person2",null);

        return "thymeleafex3";
        // classpath:templates/thymeleaf/thymeleafEx1.html
    }

    @GetMapping("/model3.do")
    public String model3(Model model) {

        log.info("HomeController-model3()실행!");

        List<String> items = Arrays.asList("spring","springboot","AWS");

//        List<String> items2 = new ArrayList<String>();
        List<String> items2 = Arrays.asList("AA","BB","CC","DD");


        // list & map
        Map<Integer, Object> itemsmap = new HashMap<Integer, Object>();
        itemsmap.put(1,"AAA");
        itemsmap.put(2,"BBB");
        itemsmap.put(3,"CCC");
        itemsmap.put(4,"DDD");

        model.addAttribute("itemsmap",itemsmap);
        model.addAttribute("items2",items2);

        return "thymeleafex4";
    }

    @GetMapping("/model4.do")
    public String model4(Model model) {

        log.info("HomeController-model4()실행!");

        // map
        Map<Object, Object> usermap = new HashMap<Object, Object>();
        usermap.put("Alice", 30); // 20 to 40
        usermap.put("Bob", 37);
        usermap.put("Charlie", 30);
        usermap.put("David", 25);
        usermap.put("Eve", 24);
        usermap.put("Frank", 28);
        usermap.put("Grace", 31);
        usermap.put("Hannah", 36);
        usermap.put("Ivy", 38);
        usermap.put("Jack", 29);

        // list & map
        List<Map<String, Object>> bookList = new ArrayList<Map<String, Object>>();

        Map<String, Object> booklistmap = new HashMap<String, Object>();
        booklistmap.put("자바의 정석", new BookStore("자바의 정석", "IT", 18000));
        booklistmap.put("Effective Java", new BookStore("Effective Java", "IT",25000));
        booklistmap.put("Clean Code", new BookStore("Clean Code", "IT", 30000));
        booklistmap.put("Head First Design Patterns", new BookStore("Head First Design Patterns", "IT", 28000));
        booklistmap.put("The Pragmatic Programmer", new BookStore("The Pragmatic Programmer", "IT", 26000));
        booklistmap.put("Introduction to Algorithms", new BookStore("Introduction to Algorithms", "IT", 45000));

        bookList.add(booklistmap);

        model.addAttribute("bookList",bookList);
        model.addAttribute("usermap",usermap);

        return "thymeleafTest";
    }
}
/*
 *  타임리프
 *   - 자바 웹 어플리케이션 개발에 사용되는
 *     서버사이드 java 템플릿(뷰 화면을 구성)
 *     html,XML,텍스트 , 자바스크립트 ,css
 *     다양하게 마크업 파일을 생성할 수 있다.
 *
 *   - 동적인 뷰를 생성을 할 수 있다.
 *   - 네츄럴 템플릿
 *     타임리프 템플릿을 실행되지 않은 상태에서도
 *     html 파일로서 자연스럽게 보여질 수 있다.
 *
 *   - 스프링에서 타임리프를 적용할 수 있다.
 *     메이븐레파지토리에서 검색해서 사용!
 *
 */
