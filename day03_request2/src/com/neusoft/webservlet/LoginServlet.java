package com.neusoft.webservlet;

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
 * @date 2020/8/28 13:23
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserDaoImpl userDao = new UserDaoImpl();
        User login =null;
        try {
            login = userDao.login(user);
        }catch (SQLException e) {
            e.printStackTrace();
        }

        if (login == null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            req.getRequestDispatcher("successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
