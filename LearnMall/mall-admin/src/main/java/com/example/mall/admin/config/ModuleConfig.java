package com.example.mall.admin.config;

import com.example.mall.mbg.config.DruidMonitorConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Author saino
 * LastModify 10:33
 */
@Configuration
@Import({DruidMonitorConfig.class})
public class ModuleConfig {
}
