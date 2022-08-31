package com.example.javabase.dto;

import com.example.javabase.model.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Author saino
 * LastModify 23:39
 */

@NoArgsConstructor
@Getter
@Setter
public class PersonDto {
    private String name;
    private List<Person> plist;
}
