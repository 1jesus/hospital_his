package com.zhiyou.aspect;

import com.zhiyou.annotation.MyLog;
import com.zhiyou.model.Aoplog;
import com.zhiyou.model.User;
import com.zhiyou.service.AoplogService;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Classname LogAspect
 * @Date 2021/12/17 22:24
 */
@Component
@Aspect
public class LogAspect {
    static Logger logger = Logger.getLogger(LogAspect.class);
    @Autowired
    private AoplogService aoplogService;

    /**
     * 增强方法
     * JoinPoint: 目标对象
     */
    @After("@annotation(com.zhiyou.annotation.MyLog)")
    public void myAfter(JoinPoint joinPoint) {
        // 1 获得目标方法名
        String methodname = joinPoint.getSignature().getName();
        logger.debug("methodname = " + methodname);

        // 2 获得请求对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        User user = (User) request.getSession().getAttribute("user");
        String name = user.getUserName();
        logger.debug("name = " + name);

        String ip = request.getRemoteHost();
        logger.debug("ip = " + ip);

        // 3 获得注解
        String desc = null;
        // 3.1 获得目标对象
        Object target = joinPoint.getTarget();
        // 3.2 获得目标对象的所有方法
        Class<?> targetClass = target.getClass();
        Method[] methods = targetClass.getDeclaredMethods();
        // 3.3 遍历已确定找到加注解的方法
        for (Method method : methods) {
            if (method.getName().equals(methodname)) {
                // 3.4 获得方法上的注解
                MyLog myLog = method.getAnnotation(MyLog.class);
                desc = myLog.value();
            }
        }
        logger.debug("desc = " + desc);

        // 4 时间
        Date date = new Date();
        Aoplog aoplog = new Aoplog();
        aoplog.setIp(ip);
        aoplog.setDate(date);
        aoplog.setDesc(desc);
        aoplog.setMethodname(methodname);
        aoplog.setUser(name);

        aoplogService.insertLog(aoplog);
    }
}

