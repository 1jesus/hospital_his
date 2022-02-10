package com.zhiyou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.common.Page;
import com.zhiyou.common.ResultObject;
import com.zhiyou.model.Drug;
import com.zhiyou.service.DrugService;
import com.zhiyou.util.FileUploadUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname Drug
 * @Date 2021/12/21 16:47
 */
@Controller
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private DrugService drugService;

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @RequestMapping("/list.do")
    public String list(@RequestParam(defaultValue = "1") int pageNo, Model model,
                       @Param("drugName") String drugName,
                       @Param("drugType") String drugType,
                       HttpServletRequest request) {
        //分页
        PageHelper.startPage(pageNo, Page.PAGE_SIZE);

        //把前端传过来的name转为value
        String para1 = request.getParameter("drugName");
        String para2 = request.getParameter("drugType");

        //查询全部
        List<Drug> list = drugService.findAll(para1, para2);
        PageInfo<Drug> pageInfo = new PageInfo<>(list);


        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("drugName", para1);
        model.addAttribute("drugType", para2);

        return "drug/index";
    }

//    /**
//     * 添加药品同时进行文件上传
//     */
//    @RequestMapping("/add.do")
//    public String add(Drug drug, HttpServletRequest request) {
//
//        String url = fileUploadUtil.upload(request);
//        drug.setDrugUrl(url);
//
//        drugService.addDrug(drug);
//
//        return "redirect:/drug/list.do";
//    }

    /**
     * 只添加药品
     * 使用ajax上传图片,然后返回图片路径,立即在jsp页面回显
     * 之前写的(文件上传)+(保存药品对象)的方法不适用了,需要重新设计一个添加药品的方法
     */
    @RequestMapping("/add.do")
    public String add2(Drug drug) {
        System.out.println("添加药品2: " + drug);
        drugService.addDrug(drug);
        return "redirect:/drug/list.do";
    }

    /**
     * 单独文件上传的方法
     */
    @RequestMapping("/upload.do")
    @ResponseBody
    public ResultObject uploadFile(HttpServletRequest request) {
        String url = fileUploadUtil.upload(request);
        return new ResultObject(200, "上传文件成功", url);
    }


    /**
     * 详情
     */
    @RequestMapping("/detail.do")
    public String detail(String drugNum, Model model) {
        Drug drug = drugService.findDrugById(drugNum);
        model.addAttribute("drug", drug);
        return "drug/look";
    }

    /**
     * 更新前(展现数据)
     */
    @RequestMapping("/update1.do")
    public String update1(@Param("drugNum") String drugNum, Model model) {
        Drug drug = drugService.selectDrugById(drugNum);
        model.addAttribute("drug", drug);
        return "drug/edit";
    }

    /**
     * 更新后(设置数据)
     */
    @RequestMapping("/update2.do")
    public String update2(Drug drug, HttpServletRequest request) {
        String url = fileUploadUtil.upload(request);
        drug.setDrugUrl(url);
        drugService.updateDrug(drug);
        return "redirect:/drug/list.do";
    }

}
//  `drug_num` varchar(100) NOT NULL COMMENT '药品编号',
//  `drug_url` varchar(100) DEFAULT NULL COMMENT '药品图片地址',
//  `purchas_price` double DEFAULT NULL COMMENT '药品进价',
//  `sale_price` double DEFAULT NULL COMMENT '药品售价',
//  `drug_name` varchar(50) DEFAULT NULL COMMENT '药品名称',
//  `drug_type` int DEFAULT NULL COMMENT '药品类型 1处方药 2非处方药',
//  `simple_detail` varchar(200) DEFAULT NULL COMMENT '简单描述',
//  `prodeced_date` date DEFAULT NULL COMMENT '生产日期',
//  `expiration_date` date DEFAULT NULL COMMENT '过期日期',
//  `quality_date` varchar(11) DEFAULT NULL COMMENT '保质期',
//  `detail` varchar(500) DEFAULT NULL COMMENT '详细描述',
//  `manufacture` varchar(80) DEFAULT NULL COMMENT '生产厂商',
//  `use_infor` varchar(300) DEFAULT NULL COMMENT '使用说明',
//  `total_stock` int DEFAULT NULL COMMENT '总的进货量',
//  `surplus` int DEFAULT NULL COMMENT '剩余量',
//  `status` int DEFAULT NULL COMMENT '状态 1销售中 2售罄',
//  `noted` varchar(300) DEFAULT NULL COMMENT '备注',