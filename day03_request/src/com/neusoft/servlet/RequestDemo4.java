package com.neusoft.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shihaobo
 * @date 2020/8/26 11:21
 */
@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 转发
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/requestDemo5");
//        requestDispatcher.forward(req,resp);

        // 转发时存储数据到request域中
//        req.setAttribute("msg","hello");
        req.setAttribute("name","shihaobo");
        req.getRequestDispatcher("/requestDemo5").forward(req,resp);
        // 转发到指定的地址:只能转发当前项目下的指定，外部的不行
//        req.getRequestDispatcher("https://www.baidu.com/").forward(req,resp);
    }
}
