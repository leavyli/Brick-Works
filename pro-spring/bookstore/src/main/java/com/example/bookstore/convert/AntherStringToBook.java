package com.example.bookstore.convert;

import com.example.bookstore.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class AntherStringToBook implements Converter<String, Book>, ConditionalConverter {
    /**
     * 将字符串转换为Book对象
     * @param source 原始字符串
     * @return book对象
     */
    @Override
    public Book convert(String source) {
        log.info("AntherStringToBook convert");

        String[] bookInfo = source.split(",");
        Book book = new Book();
        book.setTitle(bookInfo[0]);
        book.setAuthor(bookInfo[1]);
        return book;
    }

    /**
     * 判断是否支持转换
     * @param sourceType 原始类型
     * @param targetType 目标类型
     * @return 是否支持转换
     */
    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return targetType.getAnnotation(BookConverterAnnation.class) == null;
    }
}
