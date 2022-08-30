package com.example.mall.admin.config;

import com.example.mall.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Author saino
 * LastModify 6:50
 */
@Configuration
@EnableCaching
public class RedisConfig extends BaseRedisConfig {
}
