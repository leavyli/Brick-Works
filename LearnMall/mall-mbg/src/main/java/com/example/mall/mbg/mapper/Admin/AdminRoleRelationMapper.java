package com.example.mall.mbg.mapper.Admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.mbg.model.Admin.AdminRoleRelation;
import com.example.mall.mbg.model.Admin.Role;
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

}
