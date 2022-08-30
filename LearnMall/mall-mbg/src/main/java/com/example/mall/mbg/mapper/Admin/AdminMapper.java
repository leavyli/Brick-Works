package com.example.mall.mbg.mapper.Admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.mbg.model.Admin.Admin;
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
