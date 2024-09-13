package com.ss.board.repository;

import com.ss.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    // Pageable : 전달되는 매개변수로 페이징에 필요한 정보를 넘겨줘야 함.
    // - 페이지 번호, 페이지 크기, 정렬방식
    Page<Board> findAll(Pageable pageable);

    // 제목(title)
    Page<Board> findByTitleContaining(String keyword, Pageable pageable);

    // 내용(content)
    Page<Board> findByContentContaining(String keyword, Pageable pageable);

    // 제목+내용
    Page<Board> findByTitleContainingOrContentContaining(String titleKeyword, String contentKeyword, Pageable pageable);

    //Board selectById(int id);

}
