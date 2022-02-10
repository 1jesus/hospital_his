package com.zhiyou.service.impl;

import com.zhiyou.mapper.RoleMapper;
import com.zhiyou.model.Role;
import com.zhiyou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname RoleServiceImpl
 * @Date 2021/12/30 19:46
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRolesByUserid(int id) {
        return roleMapper.findRolesByUserid(id);
    }

    @Override
    public List<Role> findRoles() {
        return roleMapper.findRoles();
    }
}
