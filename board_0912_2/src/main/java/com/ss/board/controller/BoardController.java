package com.ss.board.controller;

import com.ss.board.entity.Board;
import com.ss.board.service.BoardService;
import com.ss.board.service.NaverApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private NaverApiService naverApiService;

    @GetMapping("/index")
    public String indexPage(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int pageSize) {

        Page<Board> boardList = boardService.getAllBoards(page, pageSize);

        // 게시글
        model.addAttribute("boardList", boardList.getContent());

        // 페이징처리
        model.addAttribute("page", boardList);

        return "board/index";
    }

    @GetMapping("/list")
    public String listPage(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int pageSize) {

        Page<Board> boardList = boardService.getAllBoards(page, pageSize);

        // 게시글
        model.addAttribute("boardList", boardList.getContent());

        // 페이징처리
        model.addAttribute("page", boardList);

        return "board/list";
    }


    @GetMapping("/board/search")
    public String searchPage(Model model,
                             @RequestParam String searchOption,
                             @RequestParam String keyword,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "5") int pageSize) {

        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Board> boardList = boardService.searchBoards(searchOption, keyword, pageable);

        model.addAttribute("boardList", boardList.getContent());
        model.addAttribute("page", boardList);
        model.addAttribute("searchOption", searchOption); // 추가
        model.addAttribute("keyword", keyword); // 추가
        return "board/index";
    }

    @GetMapping("board/detail/{id}")
    public String detailPage(@PathVariable int id, Model model) {
        log.info("BoardController-detailPage()");

        //Board board = boardService.selectById(id);

        //model.addAttribute("board", board);

        return "main/detail";
    }



}
