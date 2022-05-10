package com.example.bookstore.web.controller;

import com.example.bookstore.services.BookStoreService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: saino
 * @date: 2022/5/8 17:34
 */
@RestController
public class HelloController {
    private BookStoreService bookStoreService;

    public HelloController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }
}
