package com.zhiyou.mapper;

import com.zhiyou.model.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> findRolesByUserid(int id);

    List<Role> findRoles();
}