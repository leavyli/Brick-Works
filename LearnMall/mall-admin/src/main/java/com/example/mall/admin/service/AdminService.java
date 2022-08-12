package com.example.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mall.mbg.model.Admin.Admin;
import com.example.mall.admin.dto.AdminDto;

import java.util.Optional;

/**
 * Author saino
 * LastModify 7:18
 */
public interface AdminService extends IService<Admin> {
    Optional<Admin> register(AdminDto adminDto);
}
