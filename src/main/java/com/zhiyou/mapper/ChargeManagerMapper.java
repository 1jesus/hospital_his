package com.zhiyou.mapper;

import com.zhiyou.model.ChargeManager;

public interface ChargeManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChargeManager record);

    int insertSelective(ChargeManager record);

    ChargeManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChargeManager record);

    int updateByPrimaryKey(ChargeManager record);
}