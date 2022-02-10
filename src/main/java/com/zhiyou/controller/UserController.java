package com.zhiyou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.annotation.MyLog;
import com.zhiyou.common.Page;
import com.zhiyou.common.ResultObject;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.service.RoleService;
import com.zhiyou.service.UserService;
import com.zhiyou.util.EmailUtil;
import com.zhiyou.util.PhoneCodeUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Security;
import java.util.List;

/**
 * @Classname UserController
 * @Date 2021/12/20 14:12
 */
@Controller
@RequestMapping("/user")
public class UserController {
    static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    //登录
//    @MyLog("登录")
//    @RequestMapping("/login.do")
//    public String login(String username, String password, HttpSession session, Model model) {
//        /**
//         * 全局拦截
//         */
//        if (username == null || password == null) {
//            throw new MyAuthException("用户无权限");
//        }
//
//        User user = userService.findUserByLogin(username, password);
//        //logger.debug("查询的User = " + user); //
//        if (user != null || !"".equals(user)) {
//            session.setAttribute("user", user);
//        }
//
//        // 登录用户放入session
//        session.setAttribute("user",user);
//
//        // 跳转页面
//        return "redirect:/index.jsp#1/2";
//    }

    /**
     * 登录
     */
    @RequestMapping("/login.do")
    public String login(String username, String password, HttpSession session, Model model) {
        //获得token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //获得主体对象
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);// 调用自定义域方法进行认证授权
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在");
            return "forward:/login.jsp";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "forward:/login.jsp";
        }

        // 获得认证过后的对象
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        // 登录用户放入session
        session.setAttribute("user", user);

        // 跳转页面
        return "redirect:/index.jsp#1/2";
    }

    /**
     * 注册
     */
    @RequestMapping("/regist")
    public String regist(String username, String password) {
        userService.regist(username, password);
        return "forward:/login.jsp";
    }

    /**
     * 注销
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
//        request.getSession().invalidate();
        return "forward:/login.jsp";
    }

    /**
     * 给邮箱发送验证码
     */
    @RequestMapping("/send/email")
    @ResponseBody
    public ResultObject sendEmail(String email) {
        logger.debug("email = " + email);

        /**
         * 6位随机数,一行代码实现，
         * 思路是：math.random()范围是[0.0, 1.0)，
         * 那么math.random()*9+1一定是小于10的，(Math.random()*9+1)*100000一定是<10*100000=1000000的一个数
         */
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        EmailUtil.sendEmail(email, "登录xx系统验证码", String.valueOf(code));

        /**
         * 此处还应该将验证码存储,供后续输入验证码登录后与之判断验证码是否正确.
         * 一般解决方案是将验证码存入redis(缓存数据库),并设置过期时间,
         * 只要输入验证码后登录,与redis中存储的验证码不一致即登录失败
         * ================================================================
         * 但是今天没有实现,所以就手动记忆验证码....
         */

        System.out.println("生成随机 code = " + code);

        // 跳转页面
        return new ResultObject(200, "发送验证码成功");
    }

    /**
     * 使用邮箱+验证码登录
     */
    @RequestMapping("/login/email.do")
    public String loginByEmail(String email, String code, HttpSession session) {
        logger.debug("email = " + email + ",code = " + code);

        /**
         * 1 从redis中查询验证码
         * 2 查不到即认为过期,返回前端一个错误信息
         * 3 查到验证码再比较是否一致,不一致返回前端一个错误信息
         * 4 如果查到验证码,且前端输入和后端存储的验证码一致,则再继续跟进邮箱查询用户
         * ========================================
         * 目前,没有redis,暂时先不做,后期再修改
         */

        // 根据邮箱查询
        // User user = userService.findUserByEmail(email);

        // 登录用户放入session
        // session.setAttribute("user",user);

        // 跳转页面
        return "redirect:/index.jsp#1/2";
    }

    /**
     * 给手机发送验证码
     */
    @RequestMapping("/send/phone")
    @ResponseBody
    public ResultObject sendPhoneCode(String phone) {

        /**
         * 6位随机数,一行代码实现，
         * 思路是：math.random()范围是[0.0, 1.0)，
         * 那么math.random()*9+1一定是小于10的，(Math.random()*9+1)*100000一定是<10*100000=1000000的一个数
         */
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        String jsonStr = PhoneCodeUtil.sendmsg(phone, String.valueOf(code));

        /**
         * 此处还应该将验证码存储,供后续输入验证码登录后与之判断验证码是否正确.
         * 一般解决方案是将验证码存入redis(缓存数据库),并设置过期时间,
         * 只要输入验证码后登录,与redis中存储的验证码不一致即登录失败
         * ================================================================
         * 但是今天没有实现,所以就手动记忆验证码....
         */

        System.out.println("生成随机 code = " + code);

        // 跳转页面
        return new ResultObject(200, "发送验证码成功", jsonStr);
    }

    /**
     * 查询该用户,以及其角色信息
     */
    @RequestMapping("/list.do")
    public String demo(@RequestParam(defaultValue = "1") int pageNo, Model model) {
        PageHelper.startPage(pageNo, Page.PAGE_SIZE);

        List<User> list = userService.findAllUser();

        PageInfo<User> pageInfo = new PageInfo<User>(list);

        model.addAttribute("pageInfo", pageInfo);
        return "user/index";
    }

    /**
     * 查询全部角色
     */
    @RequestMapping("/role/list")
    public String findRoles(Model model) {
        List<Role> roles = roleService.findRoles();
        model.addAttribute("list", roles);

        /**
         * list集合封装的是多个list集合对象
         * 前端取出role对象对应的id,就必须先取出集合中的对象
         * 再取出对象中的id
         */
//        for (int i = 0; i < 5; i++) {
//            System.out.println(roles.get(i).getRoleNum());
//        }
        roles.forEach(System.out::println);
        return "user/add";
    }

    /**
     * 添加用户
     */
    @RequestMapping("/add")
    public String add(User user) {
        userService.add(user);
        return "redirect:/user/list.do";
    }


//    public static void main(String[] args) {
//        Md5Hash md5Hash = new Md5Hash("123456", null, 1024);
//        System.out.println(md5Hash.toHex());
//    }
}
