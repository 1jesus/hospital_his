package com.zhiyou.service;

import com.zhiyou.model.Drug;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname DrugService
 * @Date 2021/12/21 17:02
 */
public interface DrugService {

    //查询全部+分页+模糊查询
    List<Drug> findAll(String drugName, String drugType);

    //添加
    void addDrug(Drug drug);

    //详情
    Drug findDrugById(String drugNum);

    //更新前(展现数据)
    Drug selectDrugById(@Param("drugNum") String drugNum);

    //更新后(更新数据)
    Boolean updateDrug(Drug drug);
}
