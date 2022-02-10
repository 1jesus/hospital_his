package com.zhiyou.service;

import com.zhiyou.model.Doctor;
import com.zhiyou.model.DoctorVo;
import com.zhiyou.model.Drug;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Classname Doctor
 * @Date 2021/12/22 20:08
 */
public interface DoctorService {
    //查询全部+分页+模糊查询
    List<com.zhiyou.model.Doctor> findAll(Map<String, String> map);

    //添加
    void addDoctor(Doctor doctor);

    //详情
    Doctor findDoctorById(Integer id);

    //更新前(展现数据)
    Doctor selectDoctorById(@Param("id") Integer id);

    //更新后(更新数据)
    Boolean updateDoctor(Doctor doctor);

    //查询所有医生
    List<DoctorVo> allDoctor();

    //根据科室查询医生
    List<Doctor> findDoctorBySectionId(Integer sectionId);
}
