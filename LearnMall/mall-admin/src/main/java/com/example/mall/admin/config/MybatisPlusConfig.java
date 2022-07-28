package com.example.mall.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author saino
 * LastModify 9:09
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.example.mall.admin.dao","com.example.mall.admin.mapper"})
public class MybatisPlusConfig {
}
