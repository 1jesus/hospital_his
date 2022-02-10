package com.zhiyou.service.impl;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.mapper.UserRoleMapper;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.model.UserRole;
import com.zhiyou.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Date 2021/12/20 14:59
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;
//    @Override
//    public User findUserByLogin(String username, String password) {
//        return userMapper.findUserByLogin(username, password);
//    }
//
//    @Override
//    public User findUserByUsername(String username) {
//        return null;
//    }

    @Override
    public User findUserByLogin(String username, String password) {
        // 组装参数
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);

        // 调用mapper
        User user = userMapper.findUserByLogin(map);

        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public void regist(String username, String password) {
        // 生成盐值
        long salt = new Date().getTime();

        // MD5加密(参1:原密码,参2:盐值,参3:加密次数);
        String md5Password = new Md5Hash(password, String.valueOf(salt), 1024).toString();

        User user = new User();
        user.setPassword(md5Password);
        user.setUserName(username);
        user.setSalt(String.valueOf(salt));

        userMapper.regist(user);

    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public void add(User user) {
        //============= 插入用户 =============
        Date date = new Date();
        // 生成盐值
        long salt = date.getTime();
        // MD5加密(参1:原密码,参2:盐值,参3:加密次数);
        String md5Password = new Md5Hash(user.getPassword(), String.valueOf(salt), 1024).toString();
        user.setPassword(md5Password);
        user.setUpdateTime(date);
        user.setSalt(String.valueOf(salt));
        userMapper.add(user);
        //============= 插入角色 =============
        // 插入多个角色,向user_role中间表插入多条数据
        List<Role> roles = user.getRoles();
        // 创建中间关联表(user_role)对象
        UserRole userRole = new UserRole();
        // 获得的是Mapper执行插入后返回的主键值
        userRole.setUserId(user.getId());
        for (Role role : roles) {
            userRole.setRoleId(Integer.parseInt(role.getRoleNum()));
            // 使用关联对象的Mapper执行插入
            userRoleMapper.insert(userRole);
        }
    }
}
