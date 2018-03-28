package reflector;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/21 12:38
 */
public class DReflector {
    //属性集
    //set方法集
    Map<String,String> setMethods = new HashMap<String, String>();
    //get方法集
    Map<String,String> getMethods = new HashMap<String, String>();
    public DReflector(Class<?> clazz) {
        addGetMethods(clazz);
        addSetMethods(clazz);
    }

    //添加setMethod
    public void addSetMethods(Class<?> clazz){
        Method[] methods = getClassMethods(clazz);
        for (Method method:methods){
            if (method.getName().startsWith("set")){
                setMethods.put(method.getName().substring(3),method.getName());
            }
        }
    }
    //添加getMethod
    public void addGetMethods(Class<?> clazz){
        Method[] methods = getClassMethods(clazz);
        for (Method method:methods){
            if (method.getName().startsWith("get")||method.getName().startsWith("is")){
                if (method.getName().startsWith("is")) {
                    getMethods.put(method.getName().substring(2), method.getName());
                }
                if (method.getName().startsWith("get")){
                    getMethods.put(method.getName().substring(3), method.getName());
                }
            }
        }
    }

    //获取类的所有方法
    public Method[] getClassMethods(Class<?> clazz){
        Method[] methods = null;
        while (null!=clazz && clazz != Object.class){
            methods = clazz.getDeclaredMethods();
            clazz = clazz.getSuperclass();
        }
        return methods;
    }
}
