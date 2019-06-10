package com.rock.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {
    private static Properties init=new Properties();
   public static Connection getconnerction()
    {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            init.load(JDBCUtil.class.getResourceAsStream("init.properties"));
            return DriverManager.getConnection(init.getProperty("url"),init.getProperty("user"),init.getProperty("password"));
        }catch (Exception e)
        {

        }
        return  null;
    }


}
