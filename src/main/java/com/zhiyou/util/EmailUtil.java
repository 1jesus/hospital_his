package com.zhiyou.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Classname EmailUtil
 * @Date 2021/12/27 16:05
 */
public class EmailUtil {
    /**
     * @param toEmailAddress 邮件接收人的地址
     * @param emailTitle     邮件标题
     * @param emailContent   邮件内容
     */
    public static void sendEmail(String toEmailAddress, String emailTitle, String emailContent) {
        // 定义Properties对象,设置环境信息
        Properties props = new Properties();

        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送邮件的服务需要验证-->目前是以qq邮件作为邮件服务器
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");
        /**SSL认证，注意腾讯邮箱是基于SSL加密的，所有需要开启才可以使用**/
        MailSSLSocketFactory sf = null;
        Transport transport = null;
        try {
            sf = new MailSSLSocketFactory();

            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);
            // 创建会话
            Session session = Session.getInstance(props);
            // Message的实例对象表示一封电子邮件
            Message msg = new MimeMessage(session);
            // 设置邮件主题
            msg.setSubject(emailTitle);
            // 设置邮件的文本内容
            msg.setContent("<h1>登录验证码</h1><h3>" + emailContent + "</h3><span>请10分钟内使用,以防过期</span>", "text/html;charset=UTF-8");
            // 设置发件人邮箱
            msg.setFrom(new InternetAddress("2715451910@qq.com"));
            // 发送激活链接
            //msg.setContent("<h1>来自于丘比特LOVE网的注册验证消息，请点击以下链接</h1><h3><a href='http://localhost:8080/JMailDemo/CheckMailServlet?code=123456'>http://localhost:8080/JMailDemo/CheckMailServlet?code=123456</a></h3>", "text/html;charset=UTF-8");
            // 从session的环境中获取发送邮件的对象
            transport = session.getTransport();
            // 连接邮件服务器
            /*参数的意思:
             * host: 邮件服务器
             * user: 发件人邮箱
             * password: 开启smtp服务,返回的授权码
             */
            transport.connect("smtp.qq.com", "2715451910@qq.com", "cenygywysdirdffb");
            // 发送邮件: 参数1 邮件对象 参数2 接收人地址数组
            transport.sendMessage(msg, new Address[]{new InternetAddress(toEmailAddress)});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭
            try {
                transport.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 测试使用
     */
    public static void main(String[] args) {
        sendEmail("qiushiju0828@163.com", "验证码", "123456");
    }

}
