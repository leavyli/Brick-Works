package com.example.learnspringjpa.entities;

import com.example.learnspringjpa.repository.UserInfoJsonRepository;
import com.example.learnspringjpa.repository.UserJsonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

@SpringBootTest(properties = "spring.profiles.active=test")
class UserJsonTest {
    @Autowired
    private UserJsonRepository userJsonRepository;
    @Autowired
    private UserInfoJsonRepository userInfoJsonRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void userJsonOneToOne() throws JsonProcessingException {
//        var userInfo = userInfoJsonRepository.save(userInfoJson);
        var userJson = UserJson.builder().name("saino").email("ss@Sai.com").build();

        UserInfoJson userInfoJson = UserInfoJson.builder().age(20).userJson(userJson).school("Hc").build();
        userInfoJsonRepository.save(userInfoJson);

        //使用json序列化那必须解决无限循环的问题
        var objectMapper = new ObjectMapper();
        var u = userJsonRepository.findByName("saino");
        var json = objectMapper.writeValueAsString(u);
        assertThat(json, containsString("Hc"));
        System.out.println(json);

        var objectMapper2 = new ObjectMapper();
        var u2 = userInfoJsonRepository.findBySchool("Hc");
        var json2 = objectMapper.writeValueAsString(u2);
        assertThat(json2, containsString("saino"));
        System.out.println("-----------------------------------------------------");
        System.out.println(json2);

    }
}