package com.example.binddata.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @author: saino
 * @date: 2022/5/10 16:05
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStringToBook() throws Exception {
        mockMvc.perform(get("/string-to-book?book=how to speak, jhon")).andDo(print())
                .andExpect(jsonPath("$.title", is("how to speak")));
    }
}