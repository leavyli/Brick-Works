package com.example.mall.admin.config;

import com.example.mall.mbg.config.DruidMonitorConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Author saino
 * LastModify 10:33
 */
@Configuration
@Import({DruidMonitorConfig.class})
@ComponentScan({"com.example.mall.common"})
public class ModuleConfig {
}
