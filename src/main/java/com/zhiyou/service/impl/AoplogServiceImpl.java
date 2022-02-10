package com.zhiyou.service.impl;

import com.zhiyou.mapper.AoplogMapper;
import com.zhiyou.model.Aoplog;
import com.zhiyou.service.AoplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname AoplogServiceImpl
 * @Date 2021/12/27 11:23
 */
@Service
public class AoplogServiceImpl implements AoplogService {

    @Autowired
    private AoplogMapper aoplogMapper;

    @Override
    public void insertLog(Aoplog aoplog) {
        aoplogMapper.insertLog(aoplog);
    }
}
