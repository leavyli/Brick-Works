package com.example.learnspringjpa.entities;

import lombok.Getter;

@Getter
public enum Gender {
    MAIL("男性"), FEMAIL("女性");

    private final String value;

    Gender(String value) {
        this.value = value;
    }
}
