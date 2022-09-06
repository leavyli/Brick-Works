package com.example.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.admin.model.AdminRoleRelation;
import com.example.mall.admin.model.Resource;
import com.example.mall.admin.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author saino
 * Create 11:08
 */
@Mapper
public interface AdminRoleRelationMapper extends BaseMapper<AdminRoleRelation> {
    int insertList(@Param("list") List<AdminRoleRelation> adminRoleRelationList);
    List<Role> getRoleList(@Param("adminId") Long adminId);

    List<Resource> getResourceList(@Param("adminId") Long adminId);
}
