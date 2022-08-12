package com.example.mall.common.service.impl.someClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author saino
 * LastModify 10:10
 */
@Getter
@Setter
@NoArgsConstructor
public class B extends A{
    public String name;
    public String anotherName;
    public B(String name, Long id, String anotherName) {
        super(name, id);
        this.name = name;
        this.anotherName = anotherName;
    }

}
