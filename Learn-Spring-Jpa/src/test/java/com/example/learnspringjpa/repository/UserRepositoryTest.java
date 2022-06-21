package com.example.learnspringjpa.repository;

import com.example.learnspringjpa.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Profile("test")
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = userRepository.save(User.builder().name("saino").email("123@kk.com").build());
        Assertions.assertNotNull(user);
        List<User> users = userRepository.findAll();
        Assertions.assertNotNull(users);
    }

}