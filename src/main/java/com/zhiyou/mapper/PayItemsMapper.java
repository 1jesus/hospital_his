package com.zhiyou.mapper;

import com.zhiyou.model.PayItems;

public interface PayItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayItems record);

    int insertSelective(PayItems record);

    PayItems selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayItems record);

    int updateByPrimaryKey(PayItems record);
}