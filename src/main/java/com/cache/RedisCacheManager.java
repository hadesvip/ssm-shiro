package com.cache;

import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 使用redis的cache代替 spring 的cacheManager
 * Created by wangyong on 2016/7/9.
 */
@Component
public class RedisCacheManager implements CacheManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheManager.class);

    private final ConcurrentMap<String, RedisCache> caches = new ConcurrentHashMap<>();

    private String shiroProfixKey = "shiro-redis-session:";

    @Override
    public RedisCache getCache(String name) {
        LOGGER.info("[invoke RedisCache.getCache ...,cache name is" + name + "]");
        System.out.println("invoke RedisManager by " + this);

        RedisCache cache = caches.get(name);
        if (cache == null) {
            cache = new RedisCache(shiroProfixKey, true);
            caches.put(name, cache);
        }
        return cache;
    }
}
