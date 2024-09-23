package com.ss.junit.repository;

import com.ss.junit.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    Book save(Book book);
//    Book findById(long id);
//
//    Object update(Long id, Book updatedBook);
//    void deleteById(Long id);
//
//    void save(Long id, Book book);
//



}
