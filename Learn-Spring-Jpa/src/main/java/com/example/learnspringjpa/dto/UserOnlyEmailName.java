package com.example.learnspringjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Author saino
 * LastModify 8:45
 */
@Getter
@Setter
//@Builder
@AllArgsConstructor
public class UserOnlyEmailName {
    private String name;
    private String email;
}
