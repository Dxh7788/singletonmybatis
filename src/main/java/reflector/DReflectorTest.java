package reflector;

import org.and.data.model.User;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/21 12:54
 */
public class DReflectorTest {
    public static void main(String[] args) {
        DReflector reflector = new DReflector(User.class);
        for (Map.Entry<String,String> sm:reflector.setMethods.entrySet()){
            System.out.println(sm.getKey()+"的set方法是:"+sm.getValue());
        }
        for (Map.Entry<String,String> sm:reflector.getMethods.entrySet()){
            System.out.println(sm.getKey()+"的get方法是:"+sm.getValue());
        }

        //使用Mybatis Configuration默认属性创建类
        Configuration configuration = new Configuration();
        User user = new User();
        MetaObject mo = configuration.newMetaObject(user);
        Reflector rf=mo.getReflectorFactory().findForClass(User.class);
        try {
            //首先创建一个对象
            rf.getSetInvoker("name").invoke(user,new Object[]{new String("123")});
            System.out.println(rf.getGetInvoker("name").invoke(user,null));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
