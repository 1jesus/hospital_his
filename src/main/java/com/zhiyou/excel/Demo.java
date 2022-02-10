package com.zhiyou.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * @Classname Demo
 * @Date 2021/12/28 15:33
 */
public class Demo {
    public static void main(String[] args) {
        try {
            Demo.testExport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * excel导出
     */
    static void testExport() throws Exception {
        // 1 创建Excel对象,03版Excel后缀xls,07版Excel后缀xlsx
        // 1.1 创建03版
//        HSSFWorkbook workbook = new HSSFWorkbook( );
        // 1.2 创建07版
        XSSFWorkbook workbook = new XSSFWorkbook();

        // 2 创建sheet
        XSSFSheet sheet = workbook.createSheet("学生信息");

        // 3 创建行
        XSSFRow row1 = sheet.createRow(0); // 创建第一行

        // 4 行内创建列
        XSSFCell r1c1 = row1.createCell(0);// 第1行第1列

        // 5 单元格赋值
        r1c1.setCellValue("学号");

        // 1行第2列
        XSSFCell r1c2 = row1.createCell(1);// 第1行第1列
        r1c2.setCellValue("姓名");
        // 1行第3列
        XSSFCell r1c3 = row1.createCell(2);// 第1行第1列
        r1c3.setCellValue("年龄");

        XSSFRow row2 = sheet.createRow(1); // 创建第2行
        // 2行第1列
        XSSFCell r2c1 = row2.createCell(0);// 第1行第1列
        r2c1.setCellValue("1001");
        // 2行第2列
        XSSFCell r2c2 = row2.createCell(1);// 第1行第1列
        r2c2.setCellValue("张三");
        // 2行第3列
        XSSFCell r2c3 = row2.createCell(2);// 第1行第1列
        r2c3.setCellValue(18);

        // 6 设置输出路径
        FileOutputStream fos = new FileOutputStream("D:\\De(IOtest)\\学生信息.xlsx");

        // 7 输出
        workbook.write(fos);

        fos.close();
        System.out.println("导出成功!");
    }

}
