package com.example.learnspringjpa.dto;

import com.example.learnspringjpa.entities.User;
import com.example.learnspringjpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

@SpringBootTest(properties = "spring.profiles.active:test")
class UserOnlyNameTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void userOnlyName() {
        userRepository.save(User.builder().name("saino").email("saino1@kk.com").phone("12333").build());
        userRepository.save(User.builder().name("saino").email("ssaino2@kk.com").phone("333").build());
        var user = userRepository.findUserOnlyNameByEmail("saino1@kk.com");

        assertThat(user, is(not(hasProperty("email"))));
        assertThat(user, is(not(hasProperty("phone"))));


    }


}