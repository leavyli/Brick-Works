package com.example.mall.common.service;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisService<K, V> {
    /**
     * 保存属性
     */
    void set(K key, V value, long time);


    /**
     * 保存属性
     */
    void set(K key, V value);

    /**
     * 获取属性
     */
    V get(K key);


    /**
     * 获取List结构的长度
     */
    Long lSize(K key);

    /**
     * 根据索引获取List中的属性
     */
    V lIndex(K key, long index);

    /**
     * 向List结构中添加属性
     */
    Long lPush(K key, V value);


    /**
     * 获取List结构中的属性
     */
    List<V> lRange(K key, long start, long end);

    RedisTemplate<K,V> getRedisTemplate();



}

