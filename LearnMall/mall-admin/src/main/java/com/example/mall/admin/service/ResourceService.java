package com.example.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mall.mbg.model.Admin.Resource;

import java.util.List;

public interface ResourceService extends IService<Resource> {

    List<Resource> listAll();
}
