package com.example.mall.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Slf4j
class AdminControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getUserRole() throws Exception {
        this.mockMvc.perform(get("/admin/role/get")
                .contentType(MediaType.APPLICATION_JSON)
                .param("adminId", "21")
//                .content()
        ).andDo(print()).andExpect(status().isOk());
    }
}