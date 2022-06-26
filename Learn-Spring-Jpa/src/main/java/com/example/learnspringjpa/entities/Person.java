package com.example.learnspringjpa.entities;

import lombok.*;

import javax.persistence.Entity;

/**
 * Author saino
 * LastModify 12:29
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends AbstractBaseEntity {

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;

}
