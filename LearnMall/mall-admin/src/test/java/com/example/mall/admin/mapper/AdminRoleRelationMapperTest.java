package com.example.mall.admin.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class AdminRoleRelationMapperTest {
    @Autowired
    private  AdminRoleRelationMapper adminRoleRelationMapper;

    @Test
    void getResourceList() {
        var ret= adminRoleRelationMapper.getResourceList(28L);
        log.info("ret-size:{} ret:{}", ret.size(), ret);
    }
}