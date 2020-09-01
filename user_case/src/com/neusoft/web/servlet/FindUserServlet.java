package com.neusoft.web.servlet;

import com.neusoft.domain.User;
import com.neusoft.service.UserService;
import com.neusoft.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author shihaobo
 * @date 2020/8/31 20:41
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取id
        String id = req.getParameter("id");
        // 调用service方法
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);
        req.setAttribute("user",user);

        // 转发update.jsp

        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }
}
