package com.example.mall.admin.config;

import com.example.mall.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Author saino
 * LastModify 16:15
 */
@Configuration
@RequiredArgsConstructor
@ComponentScan(basePackages = {"com.example.mall.security.config","com.example.mall.security.filter"})
//@Import({CommonSecurityConfig.class, SecurityConfig.class})
public class AdminMallSecurity {
    private final AdminService adminService;

    @Bean
    public UserDetailsService userDetails() {

        return adminService::loadUserByUsername;
    }
}
