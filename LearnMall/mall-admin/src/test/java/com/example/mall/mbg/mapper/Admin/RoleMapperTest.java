package com.example.mall.mbg.mapper.Admin;

import com.example.mall.admin.MallAdminApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MallAdminApplication.class)
@Slf4j
class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    void getResourceListByRoleId() {
       var ret = roleMapper.getResourceListByRoleId(1L);
       log.info("ret:{}", ret);
    }
}