package com.example.mall.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall.admin.service.RoleService;
import com.example.mall.mbg.mapper.Admin.RoleMapper;
import com.example.mall.mbg.model.Admin.Role;
import org.springframework.stereotype.Service;

/**
 * Author saino
 * Create 16:07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
