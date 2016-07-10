package com.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 使用redis的cache代替 spring 的cacheManager
 * Created by wangyong on 2016/7/9.
 */
@Component
public class RedisCacheManager implements CacheManager {

    public RedisCacheManager() {
        System.out.println("redisCacheManager...");
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheManager.class);

    private final ConcurrentMap<String, RedisCache> caches = new ConcurrentHashMap<>();

    @Autowired
    private RedisCache redisCache;

    // private String keyPrefix = "shiro_redis_session:";


    @Override
    public RedisCache getCache(String name) {

        RedisCache cache = caches.get(name);
        if (cache == null) {
            // RedisCache redisCache = new RedisCache();
            cache = redisCache;
            caches.put(name, redisCache);
        }
        return cache;
    }
}
