package com.example.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mall.admin.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AdminServiceImplTest {
    @Autowired
    private AdminServiceImpl adminService;

    @Test
    void register() {
        var queryMap = new QueryWrapper<Admin>();

        queryMap.select("username").eq("username", "saino");
        var list = adminService.list(queryMap);
        list.stream().forEach((el)->log.info("{}", el));


    }
}