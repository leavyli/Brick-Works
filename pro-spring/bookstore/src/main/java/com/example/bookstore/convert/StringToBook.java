package com.example.bookstore.convert;

import com.example.bookstore.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToBook implements Converter<String, Book> , ConditionalConverter {
    @Override
    public Book convert(String source) {
        log.info("StringToBook convert");

        String[] bookInfo = source.split(",");
        Book book = new Book();
        book.setTitle(bookInfo[0]);
        book.setAuthor(bookInfo[1]);
        return book;
    }

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return targetType.getAnnotation(BookConverterAnnation.class) != null;
    }
}
