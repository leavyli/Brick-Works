package com.example.learnkafka.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Author saino
 * LastModify 13:03
 */
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    private int CustomerId;
    private String CustomerName;
}
