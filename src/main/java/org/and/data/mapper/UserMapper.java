package org.and.data.mapper;

import org.and.data.model.User;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/14 11:14
 */
/*@CacheNamespaceRef(value = org.and.data.mapper.UserMapper.class)*/
public interface UserMapper {
    User selectByPrimaryKey(User user);
    /*User selectByPrimaryKey(Long id);
    List<User> selectByNameAndPwd(String name, String pwd);*/
    /*@Select("SELECT DISTINCT id, name, pwd FROM USER WHERE name=#{x_name} and pwd = #{x_pwd}")*/
    /*@Options(keyColumn = "id")*/
    List<User> selectByNameAndPwd1(Map<String, String> map);
    /*void addAll(@Param("users") List<User> users);


    List<User> selectByInstance(@Param("user") User user);

    @Results(id = "BaseAnResultMap",value = {
        @Result(property = "id",column = "id",id = true),
        @Result(property = "name",column = "name"),
        @Result(property = "pwd",column = "pwd")
    }
    )

    @SelectProvider( type = SelectProviderCandicate.class,method = "selectSql")
    List<User> selectByInstance2(@Param("user") User user);

    List<User> associationQueryA();
    List<User> getUsers();
    List<Address> getAddresses();*/
    //返回值是插入的条数
    int insert(User user);
}
