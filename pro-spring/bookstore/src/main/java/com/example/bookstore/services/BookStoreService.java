package com.example.bookstore.services;

import com.example.bookstore.domain.Book;

/**
 * @author saino
 */
public interface BookStoreService {
    Book save(Book book);
    Book findById(Long id);
}
