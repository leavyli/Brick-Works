package com.example.mall.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall.admin.service.ResourceService;
import com.example.mall.admin.mapper.ResourceMapper;
import com.example.mall.admin.model.Resource;
import com.example.mall.admin.model.ResourceExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author saino
 * LastModify 19:30
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Override
    public List<Resource> listAll() {
        return this.getBaseMapper().selectByExample(new ResourceExample());
    }
}
