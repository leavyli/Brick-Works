package com.example.mall.admin.controller;

import com.example.mall.admin.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class RoleControllerTest {
    @Autowired
    RoleService roleService;


    @Test
    void testCreate() {

    }
}