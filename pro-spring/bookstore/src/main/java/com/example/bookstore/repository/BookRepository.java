package com.example.bookstore.repository;

import com.example.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByTitle(String name);
    Book findBookByIsbn(String isbn);
    Book findBooksById(Long id);
    List<Book> findBooksByAuthor(String author);
}