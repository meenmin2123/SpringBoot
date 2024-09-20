package com.ss.junit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ss.junit.entity.Book;
import com.ss.junit.service.BookService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

//    @GetMapping("/book")
//    public String bookMain() {
//        List<Book> booklists = bookService.findAll();
//        System.out.println("booklists : " + booklists.toString());
//        return "success-bookMain()";
//    }

    @PostMapping("/book")
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        log.info("BookController-saveBook()");
        log.info("Save book: {}", book);
        return new ResponseEntity<Book>(bookService.save(book), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllBook() {
        log.info("BookController-selectBook()");
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        Book book = (Book) bookService.findById(id);
       return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?> bookPutBy(@PathVariable Long id, @RequestBody Book updatedBook) {
        return new ResponseEntity<>(bookService.update(id, updatedBook), HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public String bookDeleteBy(@PathVariable Long id) {
        bookService.delete(id);
        return "success";
    }
}
