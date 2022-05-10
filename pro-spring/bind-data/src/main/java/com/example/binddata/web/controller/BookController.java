package com.example.binddata.web.controller;

import com.example.bookstore.domain.Book;
import com.example.bookstore.services.BookStoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/8 16:09
 */
@RestController
public class BookController {
    private BookStoreService bookStoreService;
    public BookController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping("/book")
    public Book getBook() {
        return bookStoreService.findById((Long.parseLong("1")));
    }

    @GetMapping("/string-to-book")
    public Book getStringToBook(@RequestParam("book") Book book) {
        return book;
    }


}
