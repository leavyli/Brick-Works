package com.example.mall.mbg.mapper.Admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mall.admin.MallAdminApplication;
import com.example.mall.mbg.model.Admin.AdminRoleRelation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest(classes = MallAdminApplication.class)
@ActiveProfiles("test")
@Slf4j
class AdminRoleRelationMapperTest {
    @Autowired
    private AdminRoleRelationMapper mapper;

    @Test
    void insertList() {
        List<AdminRoleRelation> list = List.of(new AdminRoleRelation(), new AdminRoleRelation());
        list.get(0).setAdminId(1L);
        list.get(0).setRoleId(1L);
        list.get(1).setAdminId(2L);
        list.get(1).setRoleId(2L);
        mapper.insertList(list);

        var query = new LambdaQueryWrapper<AdminRoleRelation>();
        var res = mapper.selectList(query);
        log.info("res:{}", res);
    }

    @Test
    void getRoleList() {
    }
}