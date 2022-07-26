package com.example.springannation.Service;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Author saino
 * LastModify 11:13
 */
@Entity
public class ExcludeBookService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
