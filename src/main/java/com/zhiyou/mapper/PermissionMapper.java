package com.zhiyou.mapper;

import com.zhiyou.model.Permission;
import com.zhiyou.model.Role;

import java.util.List;
import java.util.Set;

public interface PermissionMapper {
    Set<Permission> findPermissionsByRoles(List<Role> roles);
}