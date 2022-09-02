package com.example.mall.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.mall.mbg.config.DruidMonitorConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Author saino
 * LastModify 10:33
 */
@Configuration
@ComponentScan({"com.example.mall.common"})
@Import({DruidMonitorConfig.class})
public class ModuleConfig {
}
