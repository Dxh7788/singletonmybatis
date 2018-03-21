package reflector;

import org.and.data.model.User;

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
    }
}
