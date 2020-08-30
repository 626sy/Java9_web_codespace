package com.neusoft.web.servlet;

import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author shihaobo
 * @date 2020/8/28 10:59
 * 登录模块
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、设置编码
        req.setCharacterEncoding("utf-8");
        // 2、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 3、封装成对象
        User loginUser = new User();
        loginUser.setUsename(username);
        loginUser.setPassword(password);
        // 4、调用dao 中login方法
        UserDaoImpl dao = new UserDaoImpl();
        User user = null;
        try {
            user = dao.login(loginUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 5、判断
        if (user == null){
            // 登录失败
            System.out.println("登录失败");
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            System.out.println("登录成功");
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
