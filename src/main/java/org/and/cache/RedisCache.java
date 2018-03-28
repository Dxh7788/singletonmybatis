package org.and.cache;

import com.google.gson.Gson;
import org.apache.ibatis.cache.Cache;
import redis.clients.jedis.Jedis;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/23 9:33
 */
public class RedisCache implements Cache {
    private Jedis jedis;
    private String id;

    public RedisCache(String id) {
        this();
        this.id = id;
    }

    public RedisCache() {
        if (null==jedis){
            jedis = RedisUtil.getRedisConnnection();
        }
    }

    public String getId() {
        return id;
    }

    public void putObject(Object key, Object value) {
        //序列化
        Gson gson = new Gson();
        String serializeObject = gson.toJson(value);
        String serializeKey = gson.toJson(key);
        jedis.set(serializeKey,serializeObject);
    }

    //获取数据
    public Object getObject(Object key) {
        Gson gson = new Gson();
        String serializeKey = gson.toJson(key);
        return jedis.get(serializeKey);
    }

    public Object removeObject(Object key) {
        return null;
    }

    public void clear() {

    }

    public int getSize() {
        return 0;
    }

    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
