package com.example.mall.common.service.impl.someClass;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author saino
 * LastModify 9:45
 */
@Getter
@Setter
@NoArgsConstructor
public class A {
    public Long  id;
    public String name;

    public A(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    @JsonGetter
    public String getName() {
        return name;
    }
}
