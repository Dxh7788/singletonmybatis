package test;

import org.and.data.model.User;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/30 15:04
 */
public class ReflectorTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("123");
        user.setPwd("11");
        Map<String,Object> objectMap = new HashMap<String,Object>();
        objectMap.put("map",objectMap);
        objectMap.put("user",user);
        MetaObject metaObject =MetaObject.forObject(objectMap,new DefaultObjectFactory(),new DefaultObjectWrapperFactory(),new DefaultReflectorFactory());
        Object value = metaObject.getValue("user.name");
        System.out.println(value);
    }
}
