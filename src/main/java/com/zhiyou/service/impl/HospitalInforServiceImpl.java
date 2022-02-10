package com.zhiyou.service.impl;

import com.zhiyou.mapper.HospitalInforMapper;
import com.zhiyou.model.RegistrationInforVo;
import com.zhiyou.service.HospitalInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname HospitalInforServiceImpl
 * @Date 2021/12/24 10:10
 */
@Service
public class HospitalInforServiceImpl implements HospitalInforService {
    @Autowired
    private HospitalInforMapper hospitalInforMapper;

    @Override
    public List<RegistrationInforVo> findAll(Map<String, String> map) {
        return hospitalInforMapper.findAll(map);
    }

    @Override
    public RegistrationInforVo findHospitalById(Integer medicalRecord) {
        return hospitalInforMapper.findHospitalById(medicalRecord);
    }

    @Override
    public void updateStatus(Integer medicalRecord) {
        hospitalInforMapper.updateStatus(medicalRecord);
    }

    @Override
    public void updateStatus2(Integer medicalRecord) {
        hospitalInforMapper.updateStatus2(medicalRecord);
    }

    @Override
    public RegistrationInforVo updateBefore(Integer medicalRecord) {
        return hospitalInforMapper.updateBefore(medicalRecord);
    }

    @Override
    public void updateAfter(RegistrationInforVo registrationInforVo) {
        hospitalInforMapper.updateAfter(registrationInforVo);
    }

    @Override
    public void insertRegVo(RegistrationInforVo registrationInforVo) {
        hospitalInforMapper.insertRegVo(registrationInforVo);
    }
}
