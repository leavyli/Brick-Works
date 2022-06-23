package com.example.learnspringjpa.repository;

import com.example.learnspringjpa.entities.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

@SpringBootTest(properties = "spring.profiles.active:test")
@Transactional
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

    @Test
    void findUserByName() {
        var u = userRepository.save(User.builder().name("saino").email("saino@kk.com").build());
        userRepository.save(User.builder().name("saino").email("sino@kk.com").build());
        userRepository.save(User.builder().name("saino").email("siano@kk.com").build());

        var users = userRepository.findUserByName("saino");
        assertThat(users, contains(
                hasProperty("email", is("saino@kk.com")),
                hasProperty("email", is("sino@kk.com")),
                hasProperty("email", is("siano@kk.com"))
        ));
    }

    @Test
    void findByQuery() {
        userRepository.save(User.builder().name("saino").email("saino@kk.com").build());
        userRepository.save(User.builder().name("saino2").email("sino@kk.com").build());
        userRepository.save(User.builder().name("saino3").email("siano@kk.com").build());

        var user = userRepository.findByQuery("saino");

        assertThat(user, Matchers.hasProperty("name"));
        assertThat(user, Matchers.hasProperty("email"));
        assertThat(user, Matchers.hasProperty("phone"));
    }
}