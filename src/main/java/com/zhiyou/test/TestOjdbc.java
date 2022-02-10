package com.zhiyou.test;

import java.sql.*;

/**
 * @Classname TestOjdbc
 * @Date 2022/1/18 14:20
 */
public class TestOjdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        select();
//        update();
//        delete();
//        insert();
    }

    public static void insert() throws SQLException {
        // 获得连接对象
        Connection conn = ODBUtil.getConnection();
        String sql = "insert into emp(empno,ename) values (?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 1234);
        ps.setString(2, "xiaoqian");
        int result = ps.executeUpdate();
        if (result > 0) {
            System.out.println("插入成功!");
        } else {
            System.out.println("插入失败!");
        }
        ODBUtil.close(null, ps, conn);
    }

    public static void delete() throws SQLException {
        // 获得连接对象
        Connection conn = ODBUtil.getConnection();
        String sql = "delete from emp where empno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 9999);
        int result = ps.executeUpdate();
        if (result > 0) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }
        ODBUtil.close(null, ps, conn);
    }

    public static void update() throws SQLException {
        // 获得连接对象
        Connection conn = ODBUtil.getConnection();
        String sql = "update emp set sal = ? where empno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 2000);
        ps.setInt(2, 1111);
        int result = ps.executeUpdate();
        if (result > 0) {
            System.out.println("更新成功!");
        } else {
            System.out.println("更新失败!");
        }
        ODBUtil.close(null, ps, conn);
    }

    public static void select() throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "scott";
        String password = "123456";

        //2.获得连接对象
        Connection connection = DriverManager.getConnection(url, username, password);
//        PreparedStatement pre = connection.prepareStatement("select * from emp where empno =? ");
        PreparedStatement pre = connection.prepareStatement("select * from emp");
//        pre.setInt(1,7369);

        //3.执行sql
        ResultSet resultSet = pre.executeQuery();
        while (resultSet.next()) {
            int empno = resultSet.getInt("empno");
            String ename = resultSet.getString("ename");
            String job = resultSet.getString("job");
            int mgr = resultSet.getInt("mgr");
            Date hiredate = resultSet.getDate("hiredate");
            int sal = resultSet.getInt("sal");
            int comm = resultSet.getInt("comm");
            int deptno = resultSet.getInt("deptno");
            System.out.println(empno + "-" + ename + "-" + job + "-" + mgr + "-" + hiredate + "-" + sal + "-" + comm + "-" + deptno + "\t");
        }

        //4.关流
        resultSet.close();
        pre.close();
        connection.close();
    }
}
