package com.zhiyou.service;

import com.zhiyou.model.Permission;
import com.zhiyou.model.Role;

import java.util.List;
import java.util.Set;

/**
 * @Classname PermissionService
 * @Date 2021/12/30 19:43
 */
public interface PermissionService {
    Set<Permission> findPermissionsByRoles(List<Role> roles);
}
