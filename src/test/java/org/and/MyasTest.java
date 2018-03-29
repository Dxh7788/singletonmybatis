package org.and;

import org.and.data.mapper.UserMapper;
import org.and.data.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/14 11:16
 */
@Ignore
public class MyasTest {
    @Test
    public void myasConfigStartTest() throws Exception{
        String path = System.getProperty("user.dir");
        String filePath = path+File.separator+"target"+File.separator+"classes"+File.separator+"mybatis-config.xml";
        Reader reader = new InputStreamReader(new FileInputStream(filePath));
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        /*User user = userMapper.selectByPrimaryKey(1L);
        System.out.println(user.getId()+user.getName()+user.getPwd());*/
    }
}
