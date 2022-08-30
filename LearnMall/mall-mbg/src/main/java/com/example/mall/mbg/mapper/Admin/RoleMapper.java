package com.example.mall.mbg.mapper.Admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.mbg.model.Admin.Resource;
import com.example.mall.mbg.model.Admin.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author saino
 * Create 14:01
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<Resource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
