package com.example.learnspringjpa.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Author saino
 * LastModify 6:13
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User extends AbstractBaseEntity {
    private String name;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;
}
