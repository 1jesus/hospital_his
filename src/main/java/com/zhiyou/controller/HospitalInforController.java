package com.zhiyou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.common.Page;
import com.zhiyou.model.RegistrationInforVo;
import com.zhiyou.service.HospitalInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Classname HospitalInforController
 * @Date 2021/12/24 10:11
 */
@Controller
@RequestMapping("/hospital")
public class HospitalInforController {
    @Autowired
    private HospitalInforService hospitalInforService;

    /**
     * 查询全部 + 分页 + 模糊查询
     */
    @RequestMapping("/list.do")
    public String list(@RequestParam(defaultValue = "1") int pageNo, Model model,
                       @RequestParam Map<String, String> map) {
        //分页
        PageHelper.startPage(pageNo, Page.PAGE_SIZE);

        //查询全部
        List<RegistrationInforVo> list = hospitalInforService.findAll(map);
        PageInfo<RegistrationInforVo> pageInfo = new PageInfo<>(list);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("map", map);

        return "hospital/index";
    }

    /**
     * 详情
     */
    @RequestMapping("/detail.do")
    public String detail(Integer medicalRecord, Model model) {
        RegistrationInforVo hospital = hospitalInforService.findHospitalById(medicalRecord);
        model.addAttribute("hospital", hospital);
        return "hospital/detail";
    }

    /**
     * 退院
     */
    @RequestMapping("/discharged.do")
    public String updateStatus(Integer medicalRecord) {
        hospitalInforService.updateStatus(medicalRecord);
        return "redirect:/hospital/list.do";
    }

    /**
     * 出院
     */
    @RequestMapping("/discharged2.do")
    public String updateStatus2(Integer medicalRecord) {
        hospitalInforService.updateStatus2(medicalRecord);
        return "redirect:/hospital/list.do";
    }

    /**
     * 更新前(展现数据)
     */
    @RequestMapping("/update1.do")
    public String update1(Integer medicalRecord, Model model) {
        RegistrationInforVo registrationInforVo = hospitalInforService.updateBefore(medicalRecord);
        model.addAttribute("registrationInforVo", registrationInforVo);
        return "hospital/edit";
    }

    /**
     * 更新后(设置数据)
     */
    @RequestMapping("/update2.do")
    public String update2(RegistrationInforVo registrationInforVo) {
        System.out.println("打印 registrationInforVo = " + registrationInforVo);
        hospitalInforService.updateAfter(registrationInforVo);
        return "redirect:/hospital/list.do";
    }

    /**
     * 添加
     */
//    public
}
