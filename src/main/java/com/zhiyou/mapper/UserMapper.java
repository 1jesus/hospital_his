package com.zhiyou.mapper;

import com.zhiyou.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//    //登录
//    User findUserByLogin(@Param("username")String username,@Param("password")String password);

    /**
     * 登录查询
     */
    User findUserByLogin(Map<String, String> map);

    User findUserByUsername(String username);

    //注册
    void regist(User user);

    //查全部
    List<User> findAllUser();

    //添加
    void add(User user);

}