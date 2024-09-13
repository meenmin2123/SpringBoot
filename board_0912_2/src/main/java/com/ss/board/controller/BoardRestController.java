package com.ss.board.controller;

import com.ss.board.entity.Board;
import com.ss.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/board/rest")
@RestController
public class BoardRestController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public Page<Board> listPage(@RequestParam(defaultValue = "0") int page) {

        Pageable pageable = PageRequest.of(page, 5);
        return boardService.getBoardList(pageable);
    }

    @PostMapping("/search")
    public Page<Board> searchPage(String keyword, String searchOption, @RequestParam(defaultValue = "0") int page) {

        // 페이징 처리
        Pageable pageable = PageRequest.of(page, 5);

        return boardService.searchBoards(searchOption, keyword, null);
    }


}
