package org.and;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/14 11:16
 */
public class MyasTest {
    @Test(expected = IOException.class)
    public void myasConfigStartTest() throws Exception{
        Reader reader = new InputStreamReader(new FileInputStream("classpath:mybatis-config.xml"));
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
    }
}
