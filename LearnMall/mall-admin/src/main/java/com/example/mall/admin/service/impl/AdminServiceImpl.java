package com.example.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall.admin.dto.AdminDto;
import com.example.mall.admin.service.AdminService;
import com.example.mall.mbg.mapper.admin.AdminMapper;
import com.example.mall.mbg.model.Admin.Admin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author saino
 * LastModify 7:19
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    /**
     * 注册用户
     * @param adminDto
     * @return 注册成功返回Admin对象，失败返回null
     */
    @Override
    public Optional<Admin> register(AdminDto adminDto) {
        ObjectMapper mapper = new ObjectMapper();
        var admin =  mapper.convertValue(adminDto, new TypeReference<Admin>() {
        });
        //查询是否存在相同用户名的用户
        var queryMap = new QueryWrapper<Admin>();
        List<Admin> users = this.list(queryMap.eq("username", admin.getUsername()));
        if (users.size() > 0) {
            log.info("user name:{} has exists", admin.getUsername());
            return Optional.ofNullable(null);
        }
        // 添加用户
        this.save(admin);
        return Optional.ofNullable(admin);
    }

    @Override
    public String login(String username, String password) {
        return null;
    }


}
