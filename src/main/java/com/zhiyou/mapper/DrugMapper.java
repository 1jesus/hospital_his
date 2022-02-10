package com.zhiyou.mapper;

import com.zhiyou.model.Drug;
import com.zhiyou.model.RegistrationInfor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugMapper {

    //查询全部+分页+模糊查询
    List<Drug> findAll(@Param("drugName") String drugName,
                       @Param("drugType") String drugType);

    //添加
    void addDrug(Drug drug);

    //详情
    Drug findDrugById(String drugNum);

    //更新前(展现数据)
    Drug selectDrugById(@Param("drugNum") String drugNum);

    //更新后(更新数据)
    Boolean updateDrug(Drug drug);
}