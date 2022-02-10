package com.zhiyou.service;

import com.zhiyou.model.User;

import java.util.List;

/**
 * @Classname UserService
 * @Date 2021/12/20 14:57
 */
public interface UserService {
    User findUserByLogin(String username, String password);

    User findUserByUsername(String username);

    void regist(String username, String password);

    //查全部
    List<User> findAllUser();

    //添加
    void add(User user);
}
