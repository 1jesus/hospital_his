package com.zhiyou.service.impl;

import com.zhiyou.mapper.DrugMapper;
import com.zhiyou.model.Drug;
import com.zhiyou.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname DrugServiceImpl
 * @Date 2021/12/21 17:03
 */
@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugMapper drugMapper;

    //查询全部+分页+模糊查询
    @Override
    public List<Drug> findAll(String drugName, String drugType) {
        return drugMapper.findAll(drugName, drugType);
    }

    //添加
    @Override
    public void addDrug(Drug drug) {
        drugMapper.addDrug(drug);
    }

    //详情
    @Override
    public Drug findDrugById(String drugNum) {
        return drugMapper.findDrugById(drugNum);
    }

    @Override
    public Drug selectDrugById(String drugNum) {
        return drugMapper.selectDrugById(drugNum);
    }

    @Override
    public Boolean updateDrug(Drug drug) {
        return drugMapper.updateDrug(drug);
    }


}
