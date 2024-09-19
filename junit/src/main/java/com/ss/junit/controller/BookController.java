package com.ss.junit.controller;

import com.ss.junit.entity.Book;
import com.ss.junit.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/book")
    public String bookMain() {
        List<Book> booklists = bookService.findAll();
        System.out.println("booklists : " + booklists.toString());
        return "success-bookMain()";
    }

//    @PostMapping("/book")
//    public String bookMainResp() {
//        return "success";
//    }

    @GetMapping("/book/{id}")
    public String bookSelectBy(@PathVariable Long id) {
       Book booklist = bookService.findById(id);

       System.out.println("booklist : " + booklist);
       return "success";
    }

    @PutMapping("/book/{id}")
    public String bookPutBy(@PathVariable Long id, @RequestBody Book updatedBook) {
        bookService.update(id, updatedBook);

        return "success";
    }

    @DeleteMapping("/book/{id}")
    public String bookDeleteBy(@PathVariable Long id) {
        bookService.delete(id);
        return "success";
    }
}
