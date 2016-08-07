package com.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
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

    /**
     * 缓存key前缀
     */
    private String keyProfix;

    /**
     * 是否使用cache key前缀
     */
    private boolean useKeyProfix;

    @Autowired
    private JRedisClient jRedisClient;

    public RedisCache() {
    }

    public RedisCache(String keyProfix, boolean useKeyProfix) {
        this.keyProfix = keyProfix;
        this.useKeyProfix = useKeyProfix;
    }

    @Override
    public V get(K key) throws CacheException {
        if (key == null) {
            return null;
        }
        if (key instanceof String) {
            String k = (String) key;

            if (useKeyProfix) {
                k = keyProfix + k;
            }
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
            if (useKeyProfix) {
                k = keyProfix + k;
            }
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
            if (useKeyProfix) {
                k = keyProfix + k;
            }
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
