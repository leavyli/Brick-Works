package com.example.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.admin.model.Resource;
import com.example.mall.admin.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author saino
 * Create 14:01
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<Resource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
