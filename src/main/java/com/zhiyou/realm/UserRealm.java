package com.zhiyou.realm;

import com.zhiyou.model.Permission;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.service.PermissionService;
import com.zhiyou.service.RoleService;
import com.zhiyou.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @Classname UserRealm
 * @Date 2021/12/30 12:04
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 授权(查询主体的角色和权限)
     *
     * @param principals 认证成功后,放入info的对象
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 1 获得用户名
        User user = (User) principals.getPrimaryPrincipal();

        // 2 查出对应的角色
        List<Role> roles = roleService.findRolesByUserid(user.getId());
        ArrayList<String> roleNames = new ArrayList<>();
        for (Role role : roles) {
            roleNames.add(role.getRoleName());
        }

        // 3 根据角色查权限
        Set<Permission> permissions = permissionService.findPermissionsByRoles(roles);
        HashSet<String> permissionUrls = new HashSet<>();
        for (Permission permission : permissions) {
            permissionUrls.add(permission.getResourceUrl());
        }

        // 存储权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleNames);
        info.addStringPermissions(permissionUrls);
        return info;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获得用户名
        String username = (String) token.getPrincipal();
        System.out.println("获得的username = " + username);
        // 查询数据库
        User user = userService.findUserByUsername(username);
        System.out.println("查询到的user = " + user);

        // 判断密码是否一致
        String password = new String((char[]) token.getCredentials());
        // 判断用户名是否存在
        if (user != null) {
            if (username.equals(user.getUserName())) {
                String salt = user.getSalt();
                ByteSource bytes = ByteSource.Util.bytes(salt);
                // 以上没有问题,认证成功(登录成功),存储登录信息
                // 参数1,设置查询返回的用户对象,因为Controller还要获取对象存储到Session域
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), bytes, this.getName());
                return info;
            }
        }

        return null;


        // 以上没有问题,认证成功(登录成功),存储登录信息
        // 参数1,设置查询返回的用户对象,因为Controller还要获取对象存储到Session域
        //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,password,this.getName());
        //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), bytes, getName());
        //return info;
    }

    /**
     * 指定密码匹配器
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1024);
        super.setCredentialsMatcher(matcher);
    }

}

