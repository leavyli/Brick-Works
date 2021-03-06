package com.example.learnspringjpa.services;

import com.example.learnspringjpa.entities.Person;
import org.springframework.stereotype.Service;

/**
 * Author saino
 * LastModify 14:24
 */
@Service
public class PersonServiceImp extends AbstractBaseRepositoryImpl<Person, Long> implements PersonService {

    public PersonServiceImp(AbstractBaseRepository<Person, Long> abstractBaseRepository) {
        super(abstractBaseRepository);
    }
}