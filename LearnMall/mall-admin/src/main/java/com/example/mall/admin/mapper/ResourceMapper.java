package com.example.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.admin.model.Resource;
import com.example.mall.admin.model.ResourceExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {
    List<Resource> selectByExample(ResourceExample example);

}
