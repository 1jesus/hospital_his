package com.zhiyou.mapper;

import com.zhiyou.model.Dispensing;

public interface DispensingMapper {
    int deleteByPrimaryKey(String medicalRecord);

    int insert(Dispensing record);

    int insertSelective(Dispensing record);

    Dispensing selectByPrimaryKey(String medicalRecord);

    int updateByPrimaryKeySelective(Dispensing record);

    int updateByPrimaryKey(Dispensing record);
}