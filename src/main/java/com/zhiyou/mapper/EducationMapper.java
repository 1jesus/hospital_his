package com.zhiyou.mapper;

import com.zhiyou.model.Education;

public interface EducationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Education record);

    int insertSelective(Education record);

    Education selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Education record);

    int updateByPrimaryKey(Education record);
}