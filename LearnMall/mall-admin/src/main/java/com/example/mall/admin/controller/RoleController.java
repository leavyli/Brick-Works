package com.example.mall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.mall.admin.dto.RoleDto;
import com.example.mall.admin.service.RoleService;
import com.example.mall.common.api.CommonResult;
import com.example.mall.mbg.model.Admin.Role;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author saino
 * Create 15:57
 */
@Tag(name = "RoleController", description = "角色管理相关接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    @Operation(summary = "create role", description = "创建一个角色", tags = {"role"})
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult<Role> create(@RequestBody @Validated RoleDto roleDto) {
        //如果已经存在相同的角色名
        var queryWrapper = new LambdaQueryWrapper<Role>();
        queryWrapper.eq(Role::getName, roleDto.getName());
        List<Role> ret = roleService.list(queryWrapper);
        if (ret.size() > 0) {
            return CommonResult.failed("角色名字已经存在");
        }

        //添加角色
        ObjectMapper mapper = new ObjectMapper();
        Role role = mapper.convertValue(roleDto, new TypeReference<>() {
        });
        boolean isSucess = roleService.save(role);
        if (isSucess) {
            return CommonResult.success(role, "角色添加成功");
        }
        return CommonResult.failed("角色添加失败");
    }

    @Operation(summary = "update role", description = "修改一个角色", tags = {"role"})
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult<Role> update(@RequestBody @Validated RoleDto roleDto) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Role::getName, roleDto.getName());
        List<Role> ret = roleService.list(queryWrapper);
        if (ret.size() == 0) {
            return CommonResult.failed("不存在该角色");
        }

        //更新角色
        ObjectMapper mapper = new ObjectMapper();
        Role role = mapper.convertValue(roleDto, new TypeReference<>() {
        });
        var updateWrapper = new LambdaUpdateWrapper<Role>();
        updateWrapper.eq(Role::getName, roleDto.getName()).set(Role::getDescription, roleDto.getDescription()).set(Role::getStatus, roleDto.getStatus());
        return roleService.update(updateWrapper) ?
                CommonResult.success(role, "角色更新成功")
                : CommonResult.failed("角色更新失败");
    }

    @Operation(summary = "del role", description = "删除一个角色", tags = {"role"})
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public CommonResult<Role> del(@RequestBody @Validated RoleDto roleDto) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Role::getName, roleDto.getName());
        List<Role> ret = roleService.list(queryWrapper);
        if (ret.size() == 0) {
            return CommonResult.failed("不存在该角色");
        }

        //删除一个角色
        var wrapper = new LambdaQueryWrapper<Role>();
        wrapper.eq(Role::getName, roleDto.getName());
        return roleService.remove(wrapper) ?
                CommonResult.success("角色删除成功")
                : CommonResult.failed("角色删除失败");
    }

}
