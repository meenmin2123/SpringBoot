package com.ss.board.service;

import com.ss.board.entity.Board;
import com.ss.board.repository.BoardRepository;
import com.ss.board.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    // 전체 게시글 가져가기
    public Page<Board> getAllBoards(int page, int pageSize) {

//        // 페이지네이션을 위한 페이지 및 사이즈 설정
//        int page = 0;       // 게시글 메인 페이지
//        int pageSize = 5;
        Pageable pageable = PageRequest.of(page, pageSize);

        return boardRepository.findAll(pageable);
    }

    // 검색 기능(옵션 별로 게시글 검색)
    public Page<Board> searchBoards(String searchOption, String keyword,Pageable pageable) {

        Page<Board> list;

        switch (searchOption) {

            case "title":
                list = boardRepository.findByTitleContaining(keyword,pageable);
                break;
            case "content":
                list = boardRepository.findByContentContaining(keyword,pageable);
                break;
            case "titleContent":
                list = boardRepository.findByTitleContainingOrContentContaining(keyword,keyword,pageable);
                break;
            default:
                list = boardRepository.findAll(pageable);
        }
        return list;
    }

    public Page<Board> getBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board selectById(int id) {
        return boardRepository.findById(id).get();
    }
}
