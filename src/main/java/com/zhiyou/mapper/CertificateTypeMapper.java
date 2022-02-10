package com.zhiyou.mapper;

import com.zhiyou.model.CertificateType;

public interface CertificateTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CertificateType record);

    int insertSelective(CertificateType record);

    CertificateType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CertificateType record);

    int updateByPrimaryKey(CertificateType record);
}