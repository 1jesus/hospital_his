package com.zhiyou.controller;

import com.zhiyou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname RoleController
 * @Date 2022/1/1 15:49
 */
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


}
