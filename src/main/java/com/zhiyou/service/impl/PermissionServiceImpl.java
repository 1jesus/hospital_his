package com.zhiyou.service.impl;

import com.zhiyou.mapper.PermissionMapper;
import com.zhiyou.model.Permission;
import com.zhiyou.model.Role;
import com.zhiyou.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Classname PermissionServiceImpl
 * @Date 2021/12/30 19:50
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public Set<Permission> findPermissionsByRoles(List<Role> roles) {
        // 权限去重,方案一: 使用SQL去重,方案二: java代码去重
        return permissionMapper.findPermissionsByRoles(roles);
    }
}

