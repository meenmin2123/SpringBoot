package com.ss.mybatis.controller;

import com.ss.mybatis.dto.Article;
import com.ss.mybatis.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private ArticleService service;

    @GetMapping("/index.do")
    public String index(Model model) {

        log.info("HomeController-index() 실행");
        List<Article> list = service.index();

        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/article/writePage")
    public String writePage(Model model) {
        log.info("HomeController-writePage() 실행");
        return "write";
    }

    @PostMapping("/article/writePro")
    public String writePro(Model model, Article article) {
        log.info("HomeController-writePro() 실행");

        int insertRes = service.insert(article);
        System.out.println("insertRes = " + insertRes);

        if(insertRes > 0) {
            System.out.println("글 추가 완료!");
        } else {
            System.out.println("글 추가 실패");
        }

        return "redirect:/index.do";
    }

    // detailPage
    @GetMapping("/article/{id}")
    public String detailPage(Model model, @PathVariable int id) {
        log.info("HomeController-detailPage() 실행");
        System.out.println("id = " + id);

        List<Article> detailList = service.selectDetail(id);
        System.out.println("detailList = " + detailList);

        model.addAttribute("list", detailList);

        return "detailPage";
    }

    @GetMapping("/article/{id}/update")
    public String updatePage(Model model, @PathVariable int id) {
        log.info("HomeController-updatePage() 실행");
        System.out.println("id = " + id);

        List<Article> detailList = service.selectDetail(id);
        System.out.println("detailList = " + detailList);

        model.addAttribute("list", detailList);

        return "update";
    }

    @PostMapping("/articles/{id}/updatePro")
    public String updatePro(Model model, @PathVariable int id, Article article) {
        log.info("HomeController-updatePro() 실행");
        System.out.println("id = " + id);

        int updateRes = service.update(article);
        System.out.println("updateRes = " + updateRes);

        if(updateRes > 0) {
            System.out.println("글 수정 완료!");
        } else {
            System.out.println("글 수정 실패");
        }

        return "redirect:/index.do";
    }



}
