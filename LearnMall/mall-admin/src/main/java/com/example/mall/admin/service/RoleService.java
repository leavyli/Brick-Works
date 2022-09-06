package com.example.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mall.admin.model.Role;

import java.util.List;

public interface RoleService extends IService<Role> {
    int assignResource(Long roleId, List<Long> resourceIds);
}
