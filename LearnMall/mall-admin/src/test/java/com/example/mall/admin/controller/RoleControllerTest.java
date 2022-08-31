package com.example.mall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.mall.admin.service.RoleService;
import com.example.mall.mbg.model.Admin.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class RoleControllerTest {
    @Autowired
    RoleService roleService;


    @Test
    void testCreate() {
//        var wrapper = new LambdaUpdateWrapper<Role>();
//        wrapper.set(Role::getName, "hike")
//                .set(Role::getCreateTime, LocalDateTime.now());
//        roleService.update(wrapper);

        var role = Role.builder().name("kk").adminCount(12).createTime(LocalDateTime.now()).build();
        roleService.save(role);

//        var query = new LambdaQueryWrapper<Role>();
//        query.eq(Role::getName, "kk");
        var ret = roleService.list();
        ret.stream().forEach((el)->log.info("{}", el));
    }
}