package com.ss.board.service;

import com.ss.board.dto.Board;
import com.ss.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class BoardService {

    @Autowired
    private BoardMapper mapper;

    public List<Board> selectAll(int listLimit, int firstRow) {
        Map<String, Integer> params = new HashMap<>();
        params.put("listLimit", listLimit);
        params.put("firstRow", firstRow);

        return mapper.selectAll(params);
    }

    public int selectListCount() {
        return mapper.selectListCount();
    }

//    public List<Board> searchBoards(String searchType, String searchValue) {
//        Map<String, String> params = new HashMap<>();
//        params.put("searchType", searchType);
//        params.put("searchValue", searchValue);
//
//        return mapper.searchBoards(params);
//    }

    public int selectListCount(String searchType, String searchValue) {
        Map<String, String> params = new HashMap<>();
        params.put("searchType", searchType);
        params.put("searchValue", searchValue);

        return mapper.searchBoardCount(params);
    }

    public List<Board> searchBoardList(String searchType, String searchValue, int firstRow, int listLimit) {
        Map<String, Object> params = new HashMap<>();
        params.put("searchType", searchType);
        params.put("searchValue", searchValue);

        if (firstRow < 0) {
            firstRow = 0;
        }
        if (listLimit <= 0) {
            listLimit = 5; // 올바른 기본 페이지 사이즈 설정
        }
        params.put("firstRow", firstRow);
        params.put("listLimit", listLimit);

        return mapper.searchBoardList(params);
    }

    public Board selectById(int id) {
        return mapper.selectByID(id);
    }
}
