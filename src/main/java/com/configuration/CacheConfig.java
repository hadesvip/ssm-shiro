package com.configuration;

import com.cache.RedisCache;
import com.cache.RedisCacheManager;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @EnableCaching代替 <cache:annotation-driven />
 * Created by wangyong on 2016/7/9.
 */
//@Configuration
//@EnableCaching
public class CacheConfig {

    @Bean(name = "cacheManager")
    public RedisCacheManager cacheManager() {
        RedisCacheManager cacheManager = new RedisCacheManager();
        /*Cache redisCache = new RedisCache();
        Collection collection = new ArrayList<>();
        collection.add(redisCache);*/
        // cacheManager.setCaches(collection);

        return cacheManager;
    }

}
