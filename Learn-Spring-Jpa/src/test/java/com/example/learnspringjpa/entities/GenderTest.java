package com.example.learnspringjpa.entities;

import com.example.learnspringjpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.profiles.active:test")
class GenderTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void testGender() {
        User user = userRepository.save(User.builder().name("saino").email("abc@11.com").gender(Gender.FEMAIL).build());
//        assertThat(user, Matchers.hasProperty("gender", is(Gender.FEMAIL)));
    }

}