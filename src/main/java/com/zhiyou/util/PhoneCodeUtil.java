package com.zhiyou.util;

import com.alibaba.fastjson.JSONArray;

import java.io.*;
import java.net.*;
import java.security.*;
import java.text.*;
import java.util.*;

/**
 * @author QiuShiju
 * @date 2021/12/28
 * @descID:14829 帐号：cyxxhy    密码：qwer7890  地址：http://agent.izjun.cn    690条
 */
public class PhoneCodeUtil {

    static String id = "14829";        //帐号的ID
    static String ac = "cyxxhy";        //帐号
    static String pw = "qwer7890";    //帐号的密码
    // static String mobile = "18538222273";    //需要下发的手机号码
    // static String content = "【邱世举】你好";    //需要下发的短信内容
    static String xml = "http://sms.izjun.cn";

    static Date date = new Date();
    static SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
    static String dateStr = sf.format(date);//时间戳，年月日时分秒
    static String str = ac + pw + dateStr;//MD5加密，账号+密码+时间戳     把帐号和密码写上去
    static String sign = MD5Encode(str);//MD5加密值

    public static void main(String[] args) throws Exception {
        PhoneCodeUtil.sendmsg("13837695625", "123456");        //提交发送短信
        //PhoneCodeUtil.checkYUE();		//查询短信帐号余额
        //PhoneCodeUtil.GetReport();	//获取短信下发状态
        //PhoneCodeUtil.GetMo();		//获取上行回复
    }

    public static String sendmsg(String mobile, String code) {        //发送短信的接口调用
        String urlString = xml + "/v2sms.aspx?";
        String send = "action=send&userid=" + id + "&timestamp=" + dateStr + "&sign=" + sign +
                "&mobile=" + mobile + "&content=【智游科技】登录验证码是:【" + code + "】&sendTime=&extno=";
        String s = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection hp = (HttpURLConnection) url.openConnection();
            byte[] b = send.getBytes("utf-8");
            hp.setRequestMethod("POST");
            hp.setDoOutput(true);
            hp.setDoInput(true);
            OutputStream out = hp.getOutputStream();
            out.write(b);
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(hp.getInputStream(), "utf-8"));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            System.out.println("提交短信：");
            while ((inputLine = in.readLine()) != null) {
                // System.out.println(inputLine);
                sb.append(inputLine);
            }
            in.close();
            hp.disconnect();
//        System.out.println(sb.toString());
//        System.out.println("------------------" );
            // 调用了工具类,将XML解析成JSON
            s = Xml2JsonUtil.xml2JSON(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(s );
        return s;

    }

    public static void checkYUE() throws Exception {    //查询余额的接口调用
        String urlString = xml + "/v2sms.aspx?";
        String send = "action=overage&userid=" + id + "&timestamp=" + dateStr + "&sign=" + sign;
        URL url = new URL(urlString);
        HttpURLConnection hp = (HttpURLConnection) url.openConnection();
        byte[] b = send.getBytes("utf-8");
        hp.setRequestMethod("POST");
        hp.setDoOutput(true);
        hp.setDoInput(true);
        OutputStream out = hp.getOutputStream();
        out.write(b);
        out.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(hp.getInputStream(), "utf-8"));
        String inputLine;
        System.out.println("余额查询：");
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
        hp.disconnect();
        System.out.println("");
    }

    public static void GetReport() throws Exception {    //状态报告的接口调用
        String urlString = xml + "/v2statusApi.aspx?";
        String send = "action=query&userid=" + id + "&timestamp=" + dateStr + "&sign=" + sign;
        URL url = new URL(urlString);
        HttpURLConnection hp = (HttpURLConnection) url.openConnection();
        byte[] b = send.getBytes("utf-8");
        hp.setRequestMethod("POST");
        hp.setDoOutput(true);
        hp.setDoInput(true);
        OutputStream out = hp.getOutputStream();
        out.write(b);
        out.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(hp.getInputStream(), "utf-8"));
        String inputLine;
        System.out.println("状态报告：");
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
        hp.disconnect();
        System.out.println("");
    }

    public static void GetMo() throws Exception {        //上行回复的接口调用
        String urlString = xml + "/v2callApi.aspx?";
        String send = "action=query&userid=" + id + "&timestamp=" + dateStr + "&sign=" + sign;
        URL url = new URL(urlString);
        HttpURLConnection hp = (HttpURLConnection) url.openConnection();
        byte[] b = send.getBytes("utf-8");
        hp.setRequestMethod("POST");
        hp.setDoOutput(true);
        hp.setDoInput(true);
        OutputStream out = hp.getOutputStream();
        out.write(b);
        out.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(hp.getInputStream(), "utf-8"));
        String inputLine;
        System.out.println("上行回复：");
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
        hp.disconnect();
        System.out.println("");
    }

    public final static String MD5Encode(String s) {
        try {
            byte[] btInput = s.getBytes("utf-8");
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

}
