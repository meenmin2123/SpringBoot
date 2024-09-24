package com.ss.junit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ss.junit.entity.Book;
import com.ss.junit.service.BookService;

import lombok.RequiredArgsConstructor;

import java.util.List;

// CORS 외부에서 자바스크립트 요청이 들어오는 것을 막음.
// @CrossOrigin : 막는 것을 풀어주는 어노테이션
// BookController 외부에서 오는 모든 js 모든 요청을 받음.
@CrossOrigin
@RestController
@Slf4j
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<?> bookMain() {
        List<Book> booklists = bookService.findAll();
        System.out.println("booklists : " + booklists.toString());
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        log.info("BookController-saveBook()");
        log.info("Save book: {}", book);
        return new ResponseEntity<Book>(bookService.save(book), HttpStatus.CREATED);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
       return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?> bookPutBy(@PathVariable Long id, @RequestBody Book updatedBook) {
        return new ResponseEntity<>(bookService.update(id, updatedBook), HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> bookDeleteBy(@PathVariable Long id) {
        boolean res = bookService.delete(id);

        if(res) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
