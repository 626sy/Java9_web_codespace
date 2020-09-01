package com.neusoft.web;

import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.domain.User;
import com.neusoft.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shihaobo
 * @date 2020/8/31 20:41
 */
@WebServlet("/userInsertServlet")
public class UserInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserServiceImpl service = new UserServiceImpl();

        User user = new User();
        String name = req.getParameter("name");
        String gender = req.getParameter("sex");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");
        String qq = req.getParameter("qq");
        String email = req.getParameter("email");
        user.setName(name);
        user.setGender(gender);
        user.setAge(age);
        user.setAddress(address);
        user.setQq(qq);
        user.setEmail(email);
        int i = service.insertAll(user);
        while (i>0){
            req.getRequestDispatcher("/userListServlet").forward(req,resp);
        }

    }
}
