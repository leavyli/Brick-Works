package com.example.learnspringjpa.services;

import com.example.learnspringjpa.entities.AbstractBaseEntity;
import com.example.learnspringjpa.repository.AbstractBaseRepository;
import com.example.learnspringjpa.repository.AbstractBaseRepositoryImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Author saino
 * LastModify 15:31
 */
@Service
public class GenericServiceImp<T extends AbstractBaseEntity, ID extends Serializable> extends AbstractBaseRepositoryImpl<T, ID> implements GenericService<T, ID> {

    public GenericServiceImp(AbstractBaseRepository<T, ID> abstractBaseRepository) {
        super(abstractBaseRepository);
    }
}
