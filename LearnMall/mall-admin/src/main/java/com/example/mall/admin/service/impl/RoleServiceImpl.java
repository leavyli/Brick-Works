package com.example.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall.admin.mapper.RoleResourceRelationMapper;
import com.example.mall.admin.model.RoleResourceRelation;
import com.example.mall.admin.service.RoleService;
import com.example.mall.admin.mapper.RoleMapper;
import com.example.mall.admin.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author saino
 * Create 16:07
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    private final RoleResourceRelationMapper roleResourceRelationMapper;

    @Transactional
    @Override
    public int assignResource(Long roleId, List<Long> resourceIds) {
        int count = roleId == null ? 0 : resourceIds.size();
        // 先删除原来关系
        LambdaQueryWrapper<RoleResourceRelation> query= new LambdaQueryWrapper<>();
        query.eq(RoleResourceRelation::getRoleId, roleId);
        roleResourceRelationMapper.delete(query);

        //批量插入关系
        for(var resourceId: resourceIds) {
            var r = new RoleResourceRelation();
            r.setRoleId(roleId);
            r.setResourceId(resourceId);
            roleResourceRelationMapper.insert(r);
        }

        return count;
    }
}
