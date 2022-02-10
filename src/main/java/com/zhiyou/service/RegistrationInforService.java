package com.zhiyou.service;

import com.zhiyou.model.RegistExcel;
import com.zhiyou.model.RegistrationInfor;
import com.zhiyou.model.RegistrationInforVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Classname RegistrationInforService
 * @Date 2021/12/20 17:53
 */
public interface RegistrationInforService {
    //查询全部+分页+模糊查询
    List<RegistrationInforVo> findAll(Map<String, String> map);

    //添加
    Boolean addOne(RegistrationInfor registrationInfor);

    //详情
    RegistrationInfor detailRegistrationInfor(Integer medicalRecord);

    //删除
    Boolean deletelReg(Integer medicalRecord);

    //更新前(展现数据)
    RegistrationInfor findRegById(Integer medicalRecord);

    //更新后(更新数据)
    Boolean updateReg(RegistrationInfor registrationInfor);

    //批量删除
    void deleteAll(List<Integer> ids);

    //使用ajax根据病历号回显数据
    RegistrationInforVo findRegistrationInfoVoById(int medicalRecord);

    //导出Excel
    ArrayList<RegistExcel> findAllRegistToExcel();
}
