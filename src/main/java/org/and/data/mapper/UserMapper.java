package org.and.data.mapper;

import org.and.data.model.User;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/14 11:14
 */
public interface UserMapper {
    User selectByPrimaryKey(String id);
}
