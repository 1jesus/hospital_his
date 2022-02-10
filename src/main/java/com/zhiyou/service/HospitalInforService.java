package com.zhiyou.service;

import com.zhiyou.model.RegistrationInforVo;

import java.util.List;
import java.util.Map;

/**
 * @Classname HospitalInforService
 * @Date 2021/12/24 10:10
 */
public interface HospitalInforService {
    //查询全部+分页+模糊查询
    List<RegistrationInforVo> findAll(Map<String, String> map);

    //详情
    RegistrationInforVo findHospitalById(Integer medicalRecord);

    //出院
    void updateStatus(Integer medicalRecord);

    //出院
    void updateStatus2(Integer medicalRecord);

    //更新前(展现数据)
    RegistrationInforVo updateBefore(Integer medicalRecord);

    //更新后(更新数据)
    void updateAfter(RegistrationInforVo registrationInforVo);

    //添加(ajax回显数据)
    void insertRegVo(RegistrationInforVo registrationInforVo);
}
