package com.zhiyou.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.List;

/**
 * @Classname RolesOrAuthorizationFilter
 * @Date 2021/12/30 21:58
 */
public class RolesOrAuthorizationFilter extends AuthorizationFilter {
    /**
     * Shiro自己的角色拦截器时验证所有角色同时拥有才会返回true
     * <p>
     * 要解决的问题:(类当于hasAllRoles()方法)
     * /registration/*.do=authc,roles["超级管理员","院长"]
     * 权限过滤器roles中的角色都有时,才能正常访问
     * 但是正常的情况下,只要有一个角色就能访问
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        }

        List<String> roles = CollectionUtils.asList(rolesArray);
        boolean[] booleans = subject.hasRoles(roles);

        // 只要一个true,即返回true,即认为拥有角色
        boolean flag = false;
        for (boolean aBoolean : booleans) {
            if (aBoolean)
                flag = true;
        }
        return flag;
    }
}