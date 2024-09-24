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

    @Transactional(readOnly = true)
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(id + "를 찾을 수 없음."));
    }

    @Transactional
    public Book update(Long id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(id + "를 찾을 수 없음."));
        System.out.println("existingBook : " + existingBook);

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());

        return bookRepository.save(existingBook);
    }

    @Transactional
    public boolean delete(Long id) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    // 생성자를 이용해서 주입받는 방법
//    @Autowired
//    public BookService(BookRepository book) {
//        this.bookRepository = book;
//    };


}
