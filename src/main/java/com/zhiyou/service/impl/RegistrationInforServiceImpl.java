package com.zhiyou.service.impl;

import com.zhiyou.mapper.RegistrationInforMapper;
import com.zhiyou.model.RegistExcel;
import com.zhiyou.model.RegistrationInfor;
import com.zhiyou.model.RegistrationInforVo;
import com.zhiyou.service.RegistrationInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Classname RegistrationInforServiceImpl
 * @Date 2021/12/20 17:55
 */
@Service
public class RegistrationInforServiceImpl implements RegistrationInforService {
    @Autowired
    private RegistrationInforMapper registrationInforMapper;

    //查询全部+分页+模糊查询
    @Override
    public List<RegistrationInforVo> findAll(Map<String, String> map) {
        return registrationInforMapper.findAll(map);
    }

    //添加
    @Override
    public Boolean addOne(RegistrationInfor registrationInfor) {
        return registrationInforMapper.addOne(registrationInfor);
    }

    //详情
    @Override
    public RegistrationInfor detailRegistrationInfor(Integer medicalRecord) {
        return registrationInforMapper.detailRegistrationInfor(medicalRecord);
    }

    //删除
    @Override
    public Boolean deletelReg(Integer medicalRecord) {
        return registrationInforMapper.deletelReg(medicalRecord);
    }

    //更新前(展现数据)
    @Override
    public RegistrationInfor findRegById(Integer medicalRecord) {
        return registrationInforMapper.findRegById(medicalRecord);
    }

    //更新后(设置数据)
    @Override
    public Boolean updateReg(RegistrationInfor registrationInfor) {
        return registrationInforMapper.updateReg(registrationInfor);
    }

    @Override
    public void deleteAll(List<Integer> ids) {
        registrationInforMapper.deleteAll(ids);
    }

    @Override
    public RegistrationInforVo findRegistrationInfoVoById(int medicalRecord) {
        return registrationInforMapper.findRegistrationInfoVoById(medicalRecord);
    }

    @Override
    public ArrayList<RegistExcel> findAllRegistToExcel() {
        return registrationInforMapper.findAllRegistToExcel();
    }
}
