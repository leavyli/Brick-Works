package com.example.mall.common.controllers;

import com.example.mall.common.model.Book;
import com.example.mall.common.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Author saino
 * LastModify 13:03
 */
@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository repository;


    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) throws BookNotFoundException {
        return repository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @GetMapping("/")
    public Collection<Book> findBooks() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(
            @PathVariable("id") final String id, @RequestBody final Book book) {
        return book;
    }
}
