package com.neusoft.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shihaobo
 * @date 2020/8/29 10:49
 */
public class CookieTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = utf-8");
        Cookie[] cookies = req.getCookies();

        if (cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)){

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat();
                    String str_date = sdf.format(date);

                    cookie.setValue(str_date);
                    resp.addCookie(cookie);
                }
            }
        }
    }
}
