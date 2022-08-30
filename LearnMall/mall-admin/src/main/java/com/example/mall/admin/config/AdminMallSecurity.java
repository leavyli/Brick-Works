package com.example.mall.admin.config;

import com.example.mall.admin.service.AdminService;
import com.example.mall.admin.service.ResourceService;
import com.example.mall.mbg.model.Admin.Resource;
import com.example.mall.security.component.DynamicAccessDecisionManager;
import com.example.mall.security.component.DynamicSecurityMetadataSource;
import com.example.mall.security.component.DynamicSecurityService;
import com.example.mall.security.component.filter.DynamicSecurityFilter;
import com.example.mall.security.config.IgnoreUrlsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author saino
 * LastModify 16:15
 */
@Configuration
@RequiredArgsConstructor
@ComponentScan(basePackages = {"com.example.mall.security.config", "com.example.mall.security.component"})
//@Import({CommonSecurityConfig.class, SecurityConfig.class})
public class AdminMallSecurity {
    private final AdminService adminService;
    private final ResourceService resourceService;

    @Bean
    public UserDetailsService userDetails() {

        return adminService::loadUserByUsername;
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<Resource> resourceList = resourceService.listAll();
                for (var resource : resourceList) {
                    map.put(resource.getUrl(), new SecurityConfig(resource.getId() + ":" + resource.getName()));
                }

                return map;
            }
        };
    }


    @ConditionalOnBean(name = {"dynamicSecurityService"})
    @Bean
    public DynamicSecurityFilter dynamicSecurityFilter(IgnoreUrlsConfig ignoreUrlsConfig, DynamicSecurityMetadataSource dynamicSecurityMetadataSource, AccessDecisionManager accessDecisionManager) {
        return new DynamicSecurityFilter(ignoreUrlsConfig, dynamicSecurityMetadataSource, accessDecisionManager);
    }

    @ConditionalOnBean(name = {"dynamicSecurityService"})
    @Bean
    public DynamicAccessDecisionManager dynamicAccessDecisionManager() {
        return new DynamicAccessDecisionManager();
    }

    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityMetadataSource dynamicSecurityMetadataSource(DynamicSecurityService dynamicSecurityService) {
        return new DynamicSecurityMetadataSource(dynamicSecurityService);
    }
}
