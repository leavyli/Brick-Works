package com.example.learnspringjpa.services;

import com.example.learnspringjpa.entities.AbstractBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Author saino
 * LastModify 12:39
 */
@NoRepositoryBean
public interface AbstractBaseRepository<T extends AbstractBaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {

}
