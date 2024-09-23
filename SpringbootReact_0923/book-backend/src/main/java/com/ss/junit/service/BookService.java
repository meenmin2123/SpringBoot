package com.ss.junit.service;

import com.ss.junit.entity.Book;
import com.ss.junit.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    // readOnly : 실제 읽기만 할 때는 특별히 어떤 작업이 일어나지 않음.
    // - 데이터 변경, 수정, 삭제 롤백이나 커밋 작업이 필요없음.
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Object findById(Long id) {
        return bookRepository.findById(id);
    }

    public Object update(Long id, Book updatedBook) {
//        return bookRepository.update(id, updatedBook);
        return null;
    }

    public String delete(Long id) {
        bookRepository.deleteById(id);
        return "success";
    }


    // 생성자를 이용해서 주입받는 방법
//    @Autowired
//    public BookService(BookRepository book) {
//        this.bookRepository = book;
//    };


}
