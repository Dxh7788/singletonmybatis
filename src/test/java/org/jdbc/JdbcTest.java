package org.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by singltonmybatis
 *
 * @author xh.d
 * @since 2018/3/16 10:11
 */
public class JdbcTest {
    @Test
    public void jdbcTest(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbct",  "root", "anan1215");
            if (connection !=null){
                System.out.println("#======jdbc连接成功======#");
                PreparedStatement ps = connection.prepareStatement("SELECT  * FROM user where id =1");
                ps.execute();
                ResultSet rs = ps.executeQuery();
                System.out.println(rs.getString(0));
                while (rs.next()){
                    System.out.println(rs.getString(0));
                }
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
