package com.ss.junit.repository;

import com.ss.junit.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();

    Book findById(long id);

    void save(Long id, Book book);

    void deleteById(Long id);



}
