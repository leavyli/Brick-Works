package com.example.springannation.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Author saino
 * LastModify 18:28
 */

@Getter
@Setter
@Slf4j
public class OneBean {
    private String name;

    public OneBean(String name){
        this.name = name;
        log.info("oneBean init");
    }

}
