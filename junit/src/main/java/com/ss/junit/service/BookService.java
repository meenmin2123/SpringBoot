package com.ss.junit.service;

import com.ss.junit.entity.Book;
import com.ss.junit.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    // 생성자를 이용해서 주입받는 방법
//    @Autowired
//    public BookService(BookRepository book) {
//        this.bookRepository = book;
//    };

    private final BookRepository bookRepository;

//    public Book bookSave(Book book) {
//        return bookRepository.save(book);
//    }

    // 전체 조회
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // 한건 조회
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // 수정하기
    public void update(Long id, Book updatedBook) {
        bookRepository.save(updatedBook);
    }

    // 삭제
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

}
