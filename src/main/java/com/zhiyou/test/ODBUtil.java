package com.zhiyou.test;

import java.sql.*;

/**
 * @author JackCat
 * @Date 2022/1/18 21:05
 * @Description:
 */
public class ODBUtil {
    static {
        try {
            // 注册驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 第二步： 获取与oracle的连接 Connection
    static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    static String user = "scott";
    static String password = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet resultSet, PreparedStatement stmt, Connection
            conn) {
        System.out.println("关闭资源");
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
