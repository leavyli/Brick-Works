package com.example.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mall.admin.model.Admin;
import com.example.mall.admin.dto.AdminDto;
import com.example.mall.admin.model.Resource;
import com.example.mall.admin.model.Role;
import com.nimbusds.jose.JOSEException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

/**
 * Author saino
 * LastModify 7:18
 */
public interface AdminService extends IService<Admin> {
    Optional<Admin> register(AdminDto adminDto);

    String login(String username, String password) throws JOSEException;

    UserDetails loadUserByUsername(String username);

    /**
     * 通过用户ID获取资源列表
     * @param adminId 用户ID
     * @return 资源列表
     */
    List<Resource> getResourceList(Long adminId);

    int updateRole(Long adminId, List<Long> roleId);

    List<Role> getRoleList(Long adminId);
}
