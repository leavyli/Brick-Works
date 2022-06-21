package com.example.learnspringjpa.entities;

import lombok.*;

import javax.persistence.*;

/**
 * Author saino
 * LastModify 6:13
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

}
