package com.cache;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by wangyong on 2016/7/10.
 */
@Component
public class RedisSessionDao extends EnterpriseCacheSessionDAO {


    public RedisSessionDao() {
        System.out.println("redisSessionDao...");
    }

    @Autowired
    private JRedisClient jRedisClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisSessionDao.class);

    private String keyPrefix = "shiro-redis-session:";

    private long sessionExpireTime = 30 * 60;

    private void saveSession(Session session) {
        LOGGER.info("saveSession for " + session);
        if (session == null || session.getId() == null) {
            return;
        }

        String key = keyPrefix + session.getId();
        byte[] value = SerializationUtils.serialize(session);
        session.setTimeout(sessionExpireTime * 1000);
        jRedisClient.set(key.getBytes(), value, sessionExpireTime);
    }


    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            return null;
        }

        String key = keyPrefix + sessionId;
        Session session = (Session) SerializationUtils.deserialize(jRedisClient.get(key.getBytes()));

        return session;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        this.saveSession(session);
    }

    @Override
    public void delete(Session session) {

        String key = keyPrefix + session.getId();
        jRedisClient.delete(key.getBytes());
    }

    @Override
    public Collection<Session> getActiveSessions() {
      /*  Set<Session> sessions = new HashSet<>();

        String key = keyPrefix + "*";
        Set<byte[]> keys = jRedisClient.keys(key.getBytes());

        if (keys != null && keys.size() > 0) {
            for (byte[] k : keys) {
                Session session = (Session) SerializationUtils.deserialize(jRedisClient.get(k));
                sessions.add(session);
            }
        }*/

        return null;
    }
}
