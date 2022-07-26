package com.example.learnspringjpa.repository;

import com.example.learnspringjpa.entities.AbstractBaseEntity;
import com.example.learnspringjpa.services.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Author saino
 * LastModify 13:40
 */
@Repository
public interface PersonRepository<T extends AbstractBaseEntity, ID extends Serializable> extends AbstractBaseRepository<T, ID> {

}

