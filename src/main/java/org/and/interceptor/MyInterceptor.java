package org.and.interceptor;

import org.and.cache.RedisCache;
import org.and.data.model.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/28 13:56
 */
@CacheNamespace(implementation = RedisCache.class)
@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
public class MyInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        return new ArrayList<User>().add(new User());
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    public void setProperties(Properties properties) {

    }
}
