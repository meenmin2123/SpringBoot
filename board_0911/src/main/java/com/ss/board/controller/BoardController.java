package com.ss.board.controller;

import com.ss.board.dto.Board;
import com.ss.board.dto.PageNav;
import com.ss.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/board/board")
    public String mainPage(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
        log.info("BoardController-mainPage()");

        // 전체 게시글 수를 가져온다.
        int listCount = service.selectListCount();

        // 페이지당 보여줄 게시글 수
        int listLimit = 5; // 페이지당 게시글 수 설정

        // 전체 페이지 수 계산
        int totalPages = (int) Math.ceil(listCount / (double) listLimit);

        // 현재 페이지가 범위를 벗어나지 않도록 조정
        if (page < 1) {
            page = 1;
        } else if (page > totalPages) {
            page = totalPages;
        }

        int firstRow = (page - 1) * listLimit;

        List<Board> boardlist = service.selectAll(listLimit, firstRow);

        PageNav pageInfo = new PageNav(page, listCount, listLimit);
        pageInfo.pageSetting(listCount);    // 페이지 정보를 설정하는 메서드 호출

        model.addAttribute("boardlist", boardlist);
        model.addAttribute("pageInfo", pageInfo);

        return "main/board";
    }

    @GetMapping("/board/search")
    public String searchPage(Model model, @RequestParam(name = "searchType", required = false) String searchType,
                             @RequestParam(name = "searchValue", required = false) String searchValue,
                             @RequestParam(name = "page", defaultValue = "1") int page) {
        log.info("BoardController-searchPage()");
        log.info("Search Type: " + searchType);
        log.info("Search Term: " + searchValue);

        // 전체 게시글 수를 가져온다.
        int listCount = service.selectListCount(searchType, searchValue);

        // 페이지당 보여줄 게시글 수
        int listLimit = 5; // 페이지당 게시글 수 설정

        // 전체 페이지 수 계산
        int totalPages = (int) Math.ceil(listCount / (double) listLimit);

        // 현재 페이지가 범위를 벗어나지 않도록 조정
        page = Math.max(1, Math.min(page, totalPages));

        int firstRow = (page - 1) * listLimit;
        PageNav pageInfo = new PageNav(page, listCount, listLimit);
        pageInfo.pageSetting(listCount);

        // 게시물 검색
        List<Board> boardlist = service.searchBoardList(searchType,searchValue,firstRow,listLimit);

        model.addAttribute("boardlist", boardlist);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchValue", searchValue);

        return "main/board";
    }

    @GetMapping("board/detail/{id}")
    public String detailPage(@PathVariable int id, Model model) {
        log.info("BoardController-detailPage()");

        return "redirect:main/board/" + id;
    }
}
