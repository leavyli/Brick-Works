package com.example.learnspringjpa.entities;

import com.example.learnspringjpa.repository.UserInfoRepository;
import com.example.learnspringjpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = "spring.profiles.active:test")
class UserInfoTest {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void testUserInfoOneToOne() {
        User user = userRepository.save(User.builder().name("saino").email("kk@google.com").build());
        UserInfo userInfo = userInfoRepository.save(UserInfo.builder().age(20).school("school").user(user).build());
        assertEquals(userInfo.getUser(), user);

    }

}