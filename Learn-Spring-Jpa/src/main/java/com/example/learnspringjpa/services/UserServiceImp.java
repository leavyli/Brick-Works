package com.example.learnspringjpa.services;

import com.example.learnspringjpa.entities.User;
import com.example.learnspringjpa.repository.AbstractBaseRepository;
import com.example.learnspringjpa.repository.AbstractBaseRepositoryImpl;
import org.springframework.stereotype.Service;

/**
 * Author saino
 * LastModify 14:43
 */
@Service
public class UserServiceImp extends AbstractBaseRepositoryImpl<User, Long> implements UserService {
    public UserServiceImp(AbstractBaseRepository<User, Long> abstractBaseRepository) {
        super(abstractBaseRepository);
    }
}
