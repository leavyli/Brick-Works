package com.example.implementingcontroller.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/8 15:27
 */
@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerTest {
    @Autowired
    private IndexController indexController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void handleRequest() throws Exception {
        mockMvc.perform(get("/index")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Hello, Saino")));
    }
}