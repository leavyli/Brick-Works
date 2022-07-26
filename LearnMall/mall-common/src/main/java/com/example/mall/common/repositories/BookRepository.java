package com.example.mall.common.repositories;

import com.example.mall.common.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository  extends CrudRepository<Book, Long> {
    List<Book> findAll();
}
