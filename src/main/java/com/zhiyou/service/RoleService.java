package com.zhiyou.service;

import com.zhiyou.model.Role;

import java.util.List;

/**
 * @Classname RoleService
 * @Date 2021/12/30 19:43
 */
public interface RoleService {
    List<Role> findRolesByUserid(int id);

    List<Role> findRoles();
}
