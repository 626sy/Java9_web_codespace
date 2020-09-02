package com.neusoft.web.servlet;

import com.neusoft.service.UserService;
import com.neusoft.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author shihaobo
 * @date 2020/9/1 14:55
 */
@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 获取所有选中的 uid
        String[] uids = req.getParameterValues("uid");

        UserService service = new UserServiceImpl();

//        for (String id:uids){
//            service.deleteUser(id);
//        }
        service.delSelectUser(uids);
        resp.sendRedirect(req.getContextPath()+"/userListServlet");
        System.out.println(Arrays.toString(uids));

    }
}
