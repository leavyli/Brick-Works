package com.example.mall.mbg.mapper.Admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.mbg.model.Admin.Resource;
import com.example.mall.mbg.model.Admin.ResourceExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {
    List<Resource> selectByExample(ResourceExample example);

}
