package com.neusoft.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author shihaobo
 * @date 2020/8/29 14:08
 */
@WebServlet("/SessionDemo2")
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取session
        HttpSession session = req.getSession();
        // 2、获取数据
        Object msg = session.getAttribute("msg");
        System.out.println(msg);
        // 期望客户端关闭后，session也能相同
        Cookie cookie = new Cookie("JSESSION", session.getId());
        cookie.setMaxAge(20);
        resp.addCookie(cookie);


    }
}
