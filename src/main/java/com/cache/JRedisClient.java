package com.cache;

import com.configuration.PropertiesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by wangyong on 2016/7/9.
 */
//@Configuration
@Import(PropertiesConfig.class)
@Component
public class JRedisClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(JRedisClient.class);

    @Value("${redis.master.host}")
    private String masterHost;

    @Value("${redis.master.port}")
    private int masterPort;

    @Value("${redis.maxtotal}")
    private int maxTotal;

    @Value("${redis.maxwaitmillis}")
    private long maxWaitMillis;

    @Value("${redis..maxidle}")
    private int maxIdle;

    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${redis.slave1.host}")
    private String slave1Host;

    @Value("${redis.slave1.port}")
    private int slave1Port;

    // 非切片客户端连接
    private Jedis jedis;

    // 非切片连接池
    private JedisPool jedisPool;

    // 切片客户端
    private ShardedJedis shardedJedis;

    // 切片连接池
    private ShardedJedisPool shardedJedisPool;


    /**
     * 初始化redis参数
     */
    @PostConstruct
    public void init() {

        LOGGER.info("init jedis pool config...");

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        config.setTestOnBorrow(testOnBorrow);

        List<JedisShardInfo> jedisShardInfos = new ArrayList<>();
        jedisShardInfos.add(new JedisShardInfo(masterHost, masterPort, "master"));
        jedisShardInfos.add(new JedisShardInfo(slave1Host, slave1Port, "slave"));
        shardedJedisPool = new ShardedJedisPool(config, jedisShardInfos);
        shardedJedis = shardedJedisPool.getResource();

        // 非切片客户端连接
        //jedis = new Jedis(masterHost, masterPort);
    }


    /**
     * 设置缓存对象
     *
     * @param key
     * @param value
     */
    public void set(byte[] key, byte[] value) {

        String nxxx = "NX";
        String expx = "EX";

        shardedJedis.set(key, nxxx.getBytes(), expx.getBytes(), value, 333);
    }

    /**
     * 设置缓存对象，并设置过期时间
     *
     * @param key
     * @param value
     * @param expire
     */
    public void set(byte[] key, byte[] value, long expire) {

        byte[] nxxx = "NX".getBytes();
        byte[] expx = "EX".getBytes();

        shardedJedis.set(key, value, nxxx, expx, expire);
    }


    /**
     * 获取缓存对象
     *
     * @param key
     * @return
     */
    public byte[] get(byte[] key) {
        return shardedJedis.get(key);
    }


    public void delete(byte[] bytes) {
        shardedJedis.del(bytes);
    }


    public Set<byte[]> keys(byte[] partern) {
        return shardedJedis.hkeys(partern);
    }
}
