package com.zhiyou.test;

import oracle.jdbc.internal.OracleTypes;

import java.sql.*;

/**
 * @author JackCat
 * @Date 2022/1/18 21:22
 * @Description:
 */
public class TestProduce_Function {
    public static void main(String[] args) throws SQLException {
        testProcedure();
//        testFunction();

    }

    private static void testProcedure() throws SQLException {
        // 获得执行语句对象
        Connection conn = ODBUtil.getConnection();
        // 调用存储过程的语法
        String procedure = "{call findEmpInfo (?,?,?)}";
        CallableStatement cs = conn.prepareCall(procedure);
        // 向in参数赋值
        cs.setInt(1, 7788);
        // out参数需要声明
        cs.registerOutParameter(2, OracleTypes.VARCHAR);
        cs.registerOutParameter(3, OracleTypes.NUMBER);
        // 执行存储过程
        cs.execute();
        // 获取out参数的的值
        String name = cs.getString(2);
        int sal = cs.getInt(3);
        System.out.println(name + " -- " + " -- " + sal);
        conn.close();
        cs.close();
    }

    /*
     * 存储函数
     * 创建有参存储函数findEmpIncome(编号)，查询7788号员工的年收入，演示in的用法，默认in
     */
    private static void testFunction() throws SQLException {
        // 获得执行语句对象
        Connection conn = ODBUtil.getConnection();
        // 调用存储函数的语法
        // 第一个?是返回值,相当于out参数
        String function = "{? = call findEmpIncome (?)}";
        CallableStatement cs = conn.prepareCall(function);
        // out参数需要声明
        cs.registerOutParameter(1, OracleTypes.NUMBER);
        // 向in参数赋值
        cs.setInt(2, 7788);
        // 执行存储函数
        cs.execute();
        // 获取out参数的的值
        int sal = cs.getInt(1);
        System.out.println(sal);
        conn.close();
        cs.close();
    }
}
