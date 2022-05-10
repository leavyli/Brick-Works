package com.example.bookstore.services.imp;

import com.example.bookstore.domain.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.services.BookStoreService;
import org.springframework.stereotype.Service;

/**
 * @author: saino
 * @date: 2022/5/8 17:25
 */
@Service
public class BookStoreServiceImp implements BookStoreService {
    private BookRepository bookRepository;

    public BookStoreServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
