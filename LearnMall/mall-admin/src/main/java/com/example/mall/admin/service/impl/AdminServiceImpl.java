package com.example.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall.admin.bo.AdminUserDetails;
import com.example.mall.admin.dto.AdminDto;
import com.example.mall.admin.service.AdminService;
import com.example.mall.admin.service.ResourceService;
import com.example.mall.mbg.mapper.admin.AdminMapper;
import com.example.mall.mbg.model.Admin.Admin;
import com.example.mall.mbg.model.Admin.Resource;
import com.example.mall.security.util.JwtTokenUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author saino
 * LastModify 7:19
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final ResourceService resourceService;

    /**
     * 注册用户
     *
     * @param adminDto 用户信息
     * @return 注册成功返回Admin对象，失败返回null
     */
    @Override
    public Optional<Admin> register(AdminDto adminDto) {
        ObjectMapper mapper = new ObjectMapper();
        var admin = mapper.convertValue(adminDto, new TypeReference<Admin>() {
        });
        //查询是否存在相同用户名的用户
        var queryMap = new QueryWrapper<Admin>();
        List<Admin> users = this.list(queryMap.eq("username", admin.getUsername()));
        if (users.size() > 0) {
            log.info("user name:{} has exists", admin.getUsername());
            return Optional.empty();
        }
        //加密密码
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        //设置status为1，表示正常状态
        admin.setStatus(1);
        // 添加用户
        this.save(admin);
        return Optional.of(admin);
    }

    @Override
    public String login(String username, String password) throws JOSEException {
        UserDetails userDetails = this.loadUserByUsername(username);

        //验证密码
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            log.info("password not match");
            return null;
        }
        //验证用户是否禁用
        if (!userDetails.isEnabled()) {
            log.info("user not enabled");
            return null;
        }

        return jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Admin user = this.getOne(new QueryWrapper<Admin>().eq("username", username));

        if (user != null) {
            List<Resource> resources = this.getResourceList(user.getId());
            return new AdminUserDetails(user, resources);
        }
        //抛出异常
        throw new RuntimeException("user not found");
    }

    @Override
    public List<Resource> getResourceList(Long adminId) {
        return resourceService.list(new QueryWrapper<Resource>().eq("admin_id", adminId));
    }


}
