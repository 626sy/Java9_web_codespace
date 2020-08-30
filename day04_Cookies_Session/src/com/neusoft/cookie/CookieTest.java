package com.neusoft.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author shihaobo
 * @date 2020/8/29 8:55
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 有：不是第一次访问
         * 没有：是第一次
         */
        resp.setContentType("text/html;charset=utf-8");
        // 1、获取所有cookie
        Cookie[] cookies = req.getCookies();
        boolean flag = false;   // 标识有没有cookie 为lastTime
        // 2、遍历cookie数组
        if (cookies != null && cookies.length>0){
            for (Cookie cooke :cookies) {
                // 获取cookie的名称
                String name = cooke.getName();
                // 判断遍历的cookie 是否为lastTime
                if ("lastTime".equals(name)){
                    // 有 不是第一次
                    flag = true;
                    // 获取当前时间
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);

                    System.out.println("编码前str_date"+str_date);
                    // URL 编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后str_date"+str_date);

                    cooke.setValue(str_date);
                    cooke.setMaxAge(60*60*24*30);   // 一个月
                    resp.addCookie(cooke);
                    // 响应数据
                    String value = cooke.getValue();

                    System.out.println("解码前"+value);
                    // URL 解码
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后"+value);
                    resp.getWriter().write("<h1>欢迎回来，您上次访问的时间是："+value+"</h1>");
                    break;
                }
            }
        }

        if (cookies == null || cookies.length==0 || flag == false){
            // 第一次访问
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);

            System.out.println("编码前str_date"+str_date);
            // URL 编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后str_date"+str_date);

            Cookie cookie = new Cookie("lastTime", str_date);
            cookie.setMaxAge(60*60*24*30);   // 一个月
            resp.addCookie(cookie);
            resp.getWriter().write("<h1>欢迎回来，欢迎首次访问</h1>");
        }
    }
}
