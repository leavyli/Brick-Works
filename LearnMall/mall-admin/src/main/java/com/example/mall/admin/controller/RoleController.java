package com.example.mall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.mall.admin.dto.RoleDto;
import com.example.mall.admin.service.RoleService;
import com.example.mall.mbg.model.Admin.Role;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Author saino
 * Create 15:57
 */
@Tag(name = "RoleController", description = "角色管理相关接口")
@RestController
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    public void create(@RequestBody @Validated RoleDto roleDto) {
        //如果已经存在相同的角色名
        var queryWrapper = new LambdaQueryWrapper<Role>();
        queryWrapper.eq(Role::getName, roleDto.getName());
        List<Role> ret = roleService.list(queryWrapper);
        if (ret.size() > 0) {
            throw new RuntimeException("the role has exits");
        }

        //添加角色
        var wrapper = new LambdaUpdateWrapper<Role>();
        wrapper.set(Role::getName, roleDto.getName())
                .set(Role::getCreateTime, LocalDateTime.now())
                .set(roleDto.getId() == 1, Role::getStatus, 1)
                .set(roleDto.getId() == 0, Role::getStatus, 0);

        roleService.update(wrapper);
    }
}
