package com.ss.board.mapper;

import com.ss.board.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    List<Board> selectAll(Map<String, Integer> params);

    int selectListCount();

//    List<Board> searchBoards(Map<String, String> params);

    int searchBoardCount(Map<String, String> params);

    List<Board> searchBoardList(Map<String, Object> params);

    Board selectByID(int id);
}
