package com.example.mall.common.service.impl;

import com.example.mall.common.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Author saino
 * LastModify 14:15
 */
@Service
@RequiredArgsConstructor
public class RedisServiceImpl<K, V> implements RedisService<K, V> {
    private final RedisTemplate<K, V> redisTemplate;

    @Override
    public void set(K key, V value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    @Override
    public void set(K key, V value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public V get(K key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Long lSize(K key) {
        return redisTemplate.opsForList().size(key);
    }

    @Override
    public V lIndex(K key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    @Override
    public  Long lPush(K key, V value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    @Override
    public List<V> lRange(K key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    @Override
    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }
}
