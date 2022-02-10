package com.zhiyou.controller;

import com.zhiyou.common.ResultObject;
import com.zhiyou.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @Classname AjaxController
 * @Date 2021/12/23 11:25
 */
@Controller
public class AjaxController {

    /**
     * 演示ajax发送表单数据,后台封装对象
     */
    @RequestMapping("/ajax/add")
//    @ResponseBody
    public void add(@RequestBody User user, HttpServletResponse resp) throws IOException {
        System.out.println("AjaxController.add 接收前端发送数据 " + user);
        PrintWriter out = resp.getWriter();
        out.write("OK");
    }

    /**
     * @ResponseBody 可以将java代码中的<List集合>,<数组>变成json数组返回.
     */
    @RequestMapping("/ajax/month")
    @ResponseBody
    public ResultObject month() {
        ArrayList<Double> list = new ArrayList<>();
        list.add(50.0);
        list.add(40.0);
        list.add(119.0);
        list.add(90.0);
        list.add(100.0);
        list.add(466.0);
        list.add(345.4);
        list.add(123.4);
        list.add(452.3);
        list.add(88.3);
        list.add(343.4);
        list.add(199.3);
        return new ResultObject(200, "成功", list);
    }
}