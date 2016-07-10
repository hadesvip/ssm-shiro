package com.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.util.Collection;
import java.util.Set;

/**
 * Created by wangyong on 2016/7/9.
 */
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RedisCache<K, V> implements Cache<K, V> {

    private static final Logger Logger = LoggerFactory.getLogger(RedisCache.class);

    private String keyPrefix = "shiro_redis_session:";


    public RedisCache() {
        System.out.println("redisCache....");
    }

    @Autowired
    private JRedisClient jRedisClient;

    @Override
    public V get(K key) throws CacheException {
        if (key == null) {
            return null;
        }

        if (key instanceof String) {
            String k = (String) key;
            return (V) SerializationUtils.deserialize(jRedisClient.get(k.getBytes()));
        }

        return null;
    }

    @Override
    public V put(K key, V value) throws CacheException {

        if (key == null || value == null) {
            return null;
        }

        if (key instanceof String) {
            String k = (String) key;
            byte[] v = SerializationUtils.serialize(value);
            jRedisClient.set(k.getBytes(), v);

            return value;
        }

        return null;
    }

    @Override
    public V remove(K key) throws CacheException {

        if (key == null) {
            return null;
        }
        if (key instanceof String) {
            String k = (String) key;
            jRedisClient.delete(k.getBytes());
        }
        return null;
    }

    @Override
    public void clear() throws CacheException {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
