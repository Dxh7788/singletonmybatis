package test;

import org.and.data.mapper.UserMapper;
import org.and.data.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/14 12:47
 */
public class MyasTest {
    public static void main(String[] args) throws Exception {
        String path = System.getProperty("user.dir");
        String filePath = path+ File.separator+"target"+File.separator+"classes"+File.separator+"mybatis-config.xml";
        Reader reader = new InputStreamReader(new FileInputStream(filePath));
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        /**
         * 查看已经加载的配置
         * */
        /*List<ResultMap> resultMaps= new ArrayList<ResultMap>();
        resultMaps.addAll(factory.getConfiguration().getResultMaps());
        System.out.println("找到"+resultMaps.size()+"条ResultMap记录");
        for (ResultMap rm: resultMaps) {
            List<ResultMapping> resultMappings =rm.getIdResultMappings();
            System.out.println(resultMappings.size()+"个resultMappings");for (ResultMapping idrmg:resultMappings){
                System.out.println(idrmg.getColumn()+" "+idrmg.getProperty()+" "+idrmg.getJavaType());
            }

            List<ResultMapping> idResultMappings = rm.getIdResultMappings();
            System.out.println(idResultMappings.size()+"个idResultMappings");
            for (ResultMapping idrmg:idResultMappings){
                System.out.println(idrmg.getColumn()+" "+idrmg.getProperty()+" "+idrmg.getJavaType());
            }
            System.out.println(rm.getId());
        }*/
        /*
         * 找到所有的注册类型
         * */
        /*TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
        Configuration configuration = factory.getConfiguration();
        Map<String,Class<?>> maps = typeAliasRegistry.getTypeAliases();
        Map<String,Class<?>> maps0 = new HashMap<String, Class<?>>();
        maps0.putAll(maps);
        maps0.putAll(configuration.getTypeAliasRegistry().getTypeAliases());
        Set<Map.Entry<String,Class<?>>> sets = maps0.entrySet();
        System.out.println(sets.size());
        for(Map.Entry<String,Class<?>> map:sets){
            String key = map.getKey();
            Class<?> clazz = map.getValue();
            System.out.println("找到类型配置key:"+key+",类型名称为"+clazz.getName());
        }

        Collection<MappedStatement> mappedStatements =configuration.getMappedStatements();
        for (MappedStatement ms :mappedStatements){
            System.out.println(ms.getId());
        }*/
        SqlSession session = factory.openSession();
        //userMapper是通过java反射生成的实例,通过代理工厂MapperProxyFactory生成MapperProxy实例,让后MapperProxy实例调用mapper.
        UserMapper userMapper = session.getMapper(UserMapper.class);
        /*User user = userMapper.selectByPrimaryKey(1L);
        System.out.println(user.getId()+user.getName()+user.getPwd());*/
        /*Map<String,String> map = new HashMap<String, String>();
        map.put("x_name","123");
        map.put("x_pwd","23");
        List<User> users = userMapper.selectByNameAndPwd1(map);
        for (User u:users){
            System.out.println(u.getName()+":"+u.getPwd());
        }
        //开启事务,调用缓存
        session.commit();
        List<User> users0 = userMapper.selectByNameAndPwd1(map);
        for (User u:users0){
            System.out.println(u.getName()+":"+u.getPwd());
        }

        User u0 = new User();
        u0.setName("sd0");
        u0.setPwd("dd0");
        User u1 = new User();
        u1.setName("sd0");
        u1.setPwd("dd0");

        List<User> users1 = new ArrayList<User>(0);
        users1.add(u0);
        users1.add(u1);

        userMapper.addAll(users1);*/
        User u0 = new User();
        u0.setName("123");
        u0.setPwd("23");
        List<User> users = userMapper.selectByInstance(u0);
        for (User u:users){
            System.out.println(u.getName()+":"+u.getPwd());
        }
    }
}
