package com.zhiyou.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

/**
 * @Classname Demo2
 * @Date 2021/12/28 15:51
 */
public class Demo2 {
    public static void main(String[] args) {
        try {
            Demo2.testImport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testImport() throws Exception {

        // 1 获得导入的excel输入流
        FileInputStream fis = new FileInputStream("D:\\De(IOtest)\\学生信息.xlsx");

        // 2 判断是03/07版本的Excel
//        String name = file.getName( );
//        POIXMLDocument wb = null;
//        // 判断是xls还是xlxs
//        if (name.endsWith("xls")){
//            // 2 通过字节流获得excel对象
//            wb = new HSSFWorkbook(fis);  // XLS 使用HSSFWorkbook
//        } else {
//            wb = new XSSFWorkbook(fis); // XLSX 使用XSSFWorkbook
//        }

        // 3 通过文件流创建excel对象
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        // 4 读取哪个Sheet
        XSSFSheet sheet = wb.getSheetAt(0);

        // 5 读取行
        int firstRowNum = sheet.getFirstRowNum();// 获得第一行
        int lastRowNum = sheet.getLastRowNum();// 获得最后一行

        // 遍历所有行
        for (int i = firstRowNum; i <= lastRowNum; i++) {
            // 获得行
            XSSFRow row = sheet.getRow(i);
            // 获得行内列
            short firstCellNum = row.getFirstCellNum();
            short lastCellNum = row.getLastCellNum();
            for (int j = firstCellNum; j < lastCellNum; j++) {
                // 获得单元格
                XSSFCell cell = row.getCell(j);
                // 获得其中的内容
                // 先判断单元格的数据类型
                int cellType = cell.getCellType();
                Object value = null;
                switch (cellType) {
                    case 0: // 数字类型
                        value = cell.getNumericCellValue();
                        break;
                    case 1: // 字符串
                        value = cell.getStringCellValue();
                        break;
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // 关流
        fis.close();
    }

}
