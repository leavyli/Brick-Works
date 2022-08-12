package com.example.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.mbg.model.Admin.Admin;

/**
 * Author saino
 * LastModify 7:24
 */
public interface AdminMapper extends BaseMapper<Admin> {
    int deleteByPrimaryKey(Long id);

}
