package org.and.data.mapper;

import org.and.cache.RedisCache;
import org.and.data.model.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cache.decorators.LruCache;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/14 11:14
 */
@CacheNamespace(implementation = RedisCache.class)
public interface UserMapper {
    User selectByPrimaryKey(Long id);
    List<User> selectByNameAndPwd(String name, String pwd);
    @Options()
    List<User> selectByNameAndPwd1(Map<String, String> map);
}
