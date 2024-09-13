package com.ss.board.controller;

import com.ss.board.entity.Board;
import com.ss.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class FrontController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/login")
    public String loginPage() {

        return "login/loginPage";
    }




}
