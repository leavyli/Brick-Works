package com.example.springannation.repo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author saino
 * LastModify 10:44
 */
@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String author;
    private String isbn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
