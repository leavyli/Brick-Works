package com.example.mall.admin.config;

import com.example.mall.admin.service.AdminService;
import com.example.mall.security.config.CommonSecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Author saino
 * LastModify 16:15
 */
@Configuration
@RequiredArgsConstructor
@Import(CommonSecurityConfig.class)
public class AdminMallSecurity {
    private final AdminService adminService;

    @Bean
    public UserDetailsService userDetails() {

        return adminService::loadUserByUsername;
    }
}
