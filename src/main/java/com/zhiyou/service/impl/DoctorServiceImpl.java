package com.zhiyou.service.impl;

import com.zhiyou.mapper.DoctorMapper;
import com.zhiyou.model.Doctor;
import com.zhiyou.model.DoctorVo;
import com.zhiyou.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname DoctorImpl
 * @Date 2021/12/22 20:08
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public List<com.zhiyou.model.Doctor> findAll(Map<String, String> map) {
        return doctorMapper.findAll(map);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorMapper.addDoctor(doctor);
    }

    @Override
    public Doctor findDoctorById(Integer id) {
        return doctorMapper.findDoctorById(id);
    }

    @Override
    public Doctor selectDoctorById(Integer id) {
        return doctorMapper.selectDoctorById(id);
    }

    @Override
    public Boolean updateDoctor(Doctor doctor) {
        return doctorMapper.updateDoctor(doctor);
    }

    @Override
    public List<DoctorVo> allDoctor() {
        return doctorMapper.allDoctor();
    }

    @Override
    public List<Doctor> findDoctorBySectionId(Integer sectionId) {
        return doctorMapper.findDoctorBySectionId(sectionId);
    }
}