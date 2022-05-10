package com.example.bookstore.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/8 17:17
 */
public record BookDto(Long id, String title, BigDecimal price, Integer year, String author,
                      String isbn) implements Serializable {
}
