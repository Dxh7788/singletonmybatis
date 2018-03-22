package org.and.data.mapper;

import org.and.data.model.User;
import org.apache.ibatis.session.RowBounds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/14 11:14
 */
public interface UserMapper {
    User selectByPrimaryKey(Long id);
    List<User> selectByNameAndPwd(String name, String pwd);
    List<User> selectByNameAndPwd1(Map<String,String> map, RowBounds sql);
}
