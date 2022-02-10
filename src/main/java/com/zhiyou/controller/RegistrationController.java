package com.zhiyou.controller;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.annotation.MyLog;
import com.zhiyou.common.Page;
import com.zhiyou.common.ResultObject;
import com.zhiyou.model.RegistExcel;
import com.zhiyou.model.RegistrationInfor;
import com.zhiyou.model.RegistrationInforVo;
import com.zhiyou.service.RegistrationInforService;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Classname RegistrationController
 * @Date 2021/12/20 17:20
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
    static Logger logger = Logger.getLogger(RegistrationController.class);

    @Autowired
    private RegistrationInforService registrationInforService;

    /**
     * 查询全部 + 分页 + 模糊查询
     */
    @MyLog("查询全部 + 分页 + 模糊查询")
    @RequestMapping("/list.do")
    public String list(@RequestParam(defaultValue = "1") int pageNo, Model model,
                       @RequestParam Map<String, String> map) {
        //分页
        PageHelper.startPage(pageNo, Page.PAGE_SIZE);
        //查询全部
        List<RegistrationInforVo> list = registrationInforService.findAll(map);
        PageInfo<RegistrationInforVo> pageInfo = new PageInfo<>(list);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("map", map);

        return "registration/index";
    }

    /**
     * 添加挂号信息
     * 参数1 RegistrationInfor: 接收的数据封装成对象
     * 其前加注解@Valid,这样前端传过来的参数就会按照实体类加的注解进行校验
     * 参数2 BindingResult: 校验的结果
     * 如果参数没问题,其中无值
     * 如果参数校验有问题,其中就会有错误信息(实体类注解中message参数的值)
     * ===============================================================
     * ps: 目前参数校验失败时跳转的错误页面
     * 以后前端后端分离开发,如果参数校验失败,返回给前端一个错误的状态码即可
     * 前端就可以根据状态码在页面显示: 添加成功或参数不符合规则
     */
    @RequestMapping("/add")
    public String add(@Valid RegistrationInfor registrationInfor, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {  // 参数有问题
            //如果有参数不符合规则
            List<FieldError> list = bindingResult.getFieldErrors();
            for (ObjectError objectError : list) {
                //具体的信息
                String defaultMessage = objectError.getDefaultMessage();
//                logger.debug("参数校验,异常: " + defaultMessage);
                model.addAttribute("msg", defaultMessage);
                return "error";
            }
        } else { // 参数没问题,执行添加
            // 调用业务层执行添加
            registrationInforService.addOne(registrationInfor);
        }
        // 添加完跳转页面
        return "redirect:/registration/list.do";
    }

    /**
     * 详情
     */
    @RequestMapping("/detail.do")
    public String detail(@Param("medicalRecord") Integer medicalRecord, Model model) {
        RegistrationInfor registrationInfor = registrationInforService.detailRegistrationInfor(medicalRecord);
        model.addAttribute("registrationInfor", registrationInfor);
        return "registration/detail";
    }

    /**
     * 删除
     */
    @RequestMapping("/delete.do")
    public String delete(@Param("medicalRecord") Integer medicalRecord) {
        registrationInforService.deletelReg(medicalRecord);
        return "redirect:/registration/list.do";
    }

    /**
     * 更新前(展现数据)
     */
    @RequestMapping("/update1.do")
    public String update1(@Param("medicalRecord") Integer medicalRecord, Model model) {
        RegistrationInfor registrationInfor = registrationInforService.findRegById(medicalRecord);
        model.addAttribute("registrationInfor", registrationInfor);
        return "registration/edit";
    }

    /**
     * 更新前(展现数据)
     */
    @RequestMapping("/update2.do")
    public String update2(RegistrationInfor registrationInfor) {
        registrationInforService.updateReg(registrationInfor);
        return "redirect:/registration/list.do";
    }

    /**
     * 批量删除
     * 其实不是删除,退号只是更改状态,将状态改为已退号!
     */
    @RequestMapping("/deleteAll")
    public String deleteAll(@RequestParam List<Integer> ids) {
        registrationInforService.deleteAll(ids);
        return "redirect:/registration/list.do";
    }

    /**
     * 根据病历号查询一个
     */
    @RequestMapping("/one")
    @ResponseBody
    public ResultObject findRegistrationInfoVoById(int medicalRecord) {
        RegistrationInforVo regInforVo = registrationInforService.findRegistrationInfoVoById(medicalRecord);
        return new ResultObject(200, "查询病例成功", regInforVo);
    }

    /**
     * 导出Excel
     * 03/07版本的区别:
     * 文件后缀  XLS  使用 HSSFWorkbook
     * XLSX 使用 XSSFWorkbook
     */
    @RequestMapping("/export.do")
    public void exportRegistrationExcel(HttpServletResponse resp) throws IOException {
        // 查询所有挂号信息
        ArrayList<RegistExcel> registration = registrationInforService.findAllRegistToExcel();
        String[] headers = {"病例号", "姓名", "性别", "年龄", "证件号", "证件类型", "社保号", "医生姓名", "科室", "联系电话", "是否自费", "职业", "初复诊", "状态", "备注", "挂号时间", "挂号费"};//导出的Excel头部，这个要根据自己项目改一下
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        //获得第一行对象
        HSSFRow row = sheet.createRow(0);
        //给第一行对象的每个单元格设置字段
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //遍历集合数据，产生数据行
        Iterator it = registration.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            RegistExcel t = (RegistExcel) it.next();
//            System.out.println("遍历集合出的对象===================" + t);

            //利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            //获得对象中的全部字段
            Field[] fields = t.getClass().getDeclaredFields();
//            System.out.println("获得对象中的全部字段 ===============" + fields);
            for (short i = 0; i < fields.length; i++) {
                HSSFCell cell = row.createCell(i);
                Field field = fields[i];
//                System.out.println("field=====================" + field);
                //获得字段名
                String fieldName = field.getName();
                //获得方法名
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    //获得字节码文件对象
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName);
                    //执行get方法获得值===>得到属性值
                    Object value = getMethod.invoke(t);
//                    System.out.println("获得对象中的getXxx 返回值===============" + value);
                    String textValue = null;
                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        textValue = sdf.format(date);
                    } else {
                        //其它数据类型都当作字符串简单处理
                        if (value != null && !"".equals(value)) {
                            textValue = value.toString();
                        } else {
                            textValue = "";
                        }
                    }

                    HSSFRichTextString richString = new HSSFRichTextString(textValue);
                    cell.setCellValue(richString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // 解决响应中文文件名乱码问题
        String filename = URLEncoder.encode("挂号信息表", "utf-8");
        // 浏览器响应下载弹框
        resp.setHeader("Content-disposition", "attachment;filename=" + filename + ".xls");
        resp.setContentType("application/msexcel");
        // 输出
        OutputStream out = resp.getOutputStream();
        workbook.write(out);
        out.close();
    }

    /**
     * 使用EasyExcel导出
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("/export2.do")
    public void printEasyExcel(HttpServletResponse response) throws IOException {
        //(1).查询获取数据列表
        ArrayList<RegistExcel> list = registrationInforService.findAllRegistToExcel();
        System.out.println("封装到的list = " + list);
        //(2).配置下载属性
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        //下载时文件的名称
        String fileName = URLEncoder.encode("挂号信息2", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        //(3).生成并下载Excel文件
        EasyExcel.write(response.getOutputStream()).head(RegistExcel.class).sheet("挂号信息2").doWrite(list);
    }

}