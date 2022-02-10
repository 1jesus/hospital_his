package com.zhiyou.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname MyExceptionInterceptor
 * @Date 2021/12/27 14:53
 */
@Component      //自定义一个异常拦截器
public class MyExceptionInterceptor implements HandlerExceptionResolver {

    /**
     * @param request  抛异常时的请求对象
     * @param response 抛异常时的响应对象
     * @param handler  抛异常时的Controller对象
     * @param ex       抛出的异常对象
     * @return ModelAndView, 可以将异常处理就返回自定义数据和自定义页面
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        // 建议是将异常记录到日志文件,或者记录到数据库
        // 此处省略了....
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ex.printStackTrace();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        ModelAndView mv = new ModelAndView();
        // 判断是哪种异常
//        if (ex instanceof MyAuthException) {// 权限异常
//            mv.addObject("msg", ex.getMessage());
//            mv.setViewName("error");// 经过视图解析器,拼接前缀后缀
//        } else { // ...此处可以根据情况再判断,但是今天没有其他特殊异常
//            mv.addObject("msg", "程序出问题了,请联系管理员");
//            mv.setViewName("error");// 经过视图解析器,拼接前缀后缀
//        }

        return mv;
    }
}
