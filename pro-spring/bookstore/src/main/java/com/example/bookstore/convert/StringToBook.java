package com.example.bookstore.convert;

import com.example.bookstore.domain.Book;
import org.springframework.core.convert.converter.Converter;

/**
 * @author: saino
 * @date: 2022/5/10 15:33
 */
public class StringToBook implements Converter<String, Book> {
    @Override
    public Book convert(String source) {
        String[] bookInfo = source.split(",");
        Book book = new Book();
        book.setTitle(bookInfo[0]);
        book.setAuthor(bookInfo[1]);
        return book;
    }
}
