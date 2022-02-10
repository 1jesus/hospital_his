package com.zhiyou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.common.Page;
import com.zhiyou.common.ResultObject;
import com.zhiyou.model.Doctor;
import com.zhiyou.model.DoctorVo;
import com.zhiyou.service.impl.DoctorServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Classname DoctorController
 * @Date 2021/12/22 20:09
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorServiceImpl doctorService;

    /**
     * 查询全部 + 分页 + 模糊查询
     */
    @RequestMapping("/list.do")
    public String list(@RequestParam(defaultValue = "1") int pageNo, Model model,
                       @RequestParam Map<String, String> map) {
        //分页
        PageHelper.startPage(pageNo, Page.PAGE_SIZE);

        //查询全部
        List<Doctor> list = doctorService.findAll(map);
        PageInfo<Doctor> pageInfo = new PageInfo<>(list);


        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("map", map);

        return "doctor/index";
    }

    /**
     * 添加医生
     */
    @RequestMapping("/add.do")
    public String addDoctor(Doctor doctor) {
        doctorService.addDoctor(doctor);
        return "redirect:/drug/list.do";
    }

    /**
     * 详情
     */
    @RequestMapping("/detail.do")
    public String detail(Integer id, Model model) {
        Doctor doctor = doctorService.findDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "doctor/detail";
    }

    /**
     * 更新前(展现数据)
     */
    @RequestMapping("/update1.do")
    public String update1(@Param("id") Integer id, Model model) {
        Doctor doctor = doctorService.selectDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "doctor/edit";
    }

    /**
     * 更新后(设置数据)
     */
    @RequestMapping("/update2.do")
    public String update2(Doctor doctor, HttpServletRequest request) {
        doctorService.updateDoctor(doctor);
        return "redirect:/doctor/list.do";
    }

    /**
     * 根据科室查询医生
     *
     * @ResponseBody : 将请求中的JSON转换为java对象
     * @RequestBody : 将返回的java对象转为JSON对象
     */
    @RequestMapping("/findDoctors.do")
    @ResponseBody
    public ResultObject findDoctorsBySectionId(Integer sectionId) {
        System.out.println("sectionId ========== " + sectionId);

        List<Doctor> doctors = doctorService.findDoctorBySectionId(sectionId);

        ResultObject resultObject = new ResultObject(200, "查询医生成功", doctors);
        return resultObject;
    }

    /**
     * 查询所有医生
     */
    @RequestMapping("/docList.do")
    public String demo(Model model) {
        List<DoctorVo> doctorList = doctorService.allDoctor();
        model.addAttribute("doctorList", doctorList);
        System.out.println(doctorList);
        return "registration/add";
    }
}
