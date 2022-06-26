package com.example.learnspringjpa.dto;

import com.example.learnspringjpa.TruncateDatabaseBasicOnHibernateService;
import com.example.learnspringjpa.entities.User;
import com.example.learnspringjpa.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasProperty.hasProperty;

@SpringBootTest(properties = "spring.profiles.active:test")
class UserOnlyEmailNameTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TruncateDatabaseBasicOnHibernateService truncateDatabaseBasicOnHibernateService;

    @BeforeEach
    void truncateDatabase() throws Exception {
        truncateDatabaseBasicOnHibernateService.truncate();
    }


    @Test
    void userOnlyEmailName() {
        userRepository.save(User.builder().name("saino").email("saino1@kk.com").phone("12333").build());
        userRepository.save(User.builder().name("saino").email("ssaino2@kk.com").phone("333").build());
        UserOnlyEmailName user = userRepository.findByEmail("saino1@kk.com");

        assertThat(user, is(not(hasProperty("phone"))));


    }

}