package test;

import org.and.data.mapper.UserMapper;
import org.and.data.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/4/2 15:05
 */
public class SpringMybatisTest {

    public static void main(String[] args) {
        while (true) {
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*UserMapper userMapper = (UserMapper) context.getBean("userMapper");*/
        /*if (null!=userMapper){
            System.out.println("执行成功");
        }*/
            Map<String, String> map = new HashMap<String, String>();
            map.put("x_name", "123");
            map.put("x_pwd", "23");
            SqlSession sqlSession = (SqlSession) context.getBean("sqlSession");
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = userMapper.selectByNameAndPwd1(map);
            //验证一级缓存
            for (User u : users) {
                System.out.println(u.getName() + ":" + u.getPwd());
            }
        }
    }
}
