package com.example.learnspringjpa.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author saino
 * LastModify 12:28
 */
@MappedSuperclass
@Getter
@Setter
public class AbstractBaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    @Version
    private int version;
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AbstractBaseEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
