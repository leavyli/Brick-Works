package com.example.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.admin.model.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author saino
 * LastModify 7:24
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    int deleteByPrimaryKey(Long id);

    List<Admin> findAllAdminsByEmail(String email);

}
