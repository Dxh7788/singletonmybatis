package org.and.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/23 9:39
 */
public class RedisUtil {

    public static Jedis getRedisConnnection(){
        //测试环节,每次都开启一个连接
        JedisPool jedisPool = new JedisPool("127.0.0.1",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.auth("foobared");
        return jedis;
    }
}
