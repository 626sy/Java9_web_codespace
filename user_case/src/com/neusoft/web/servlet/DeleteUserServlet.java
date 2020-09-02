package com.neusoft.web.servlet;

import com.neusoft.domain.User;
import com.neusoft.service.UserService;
import com.neusoft.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

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
@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、设置编码
        req.setCharacterEncoding("utf-8");
        // 2、获取参数
        String id = req.getParameter("id");
        System.out.println(id);

        // 4、调用service 删除
        UserService service = new UserServiceImpl();
        service.deleteUser(id);
        // 5、重定向到list.jsp
//        resp.sendRedirect(req.getContextPath()+"/userListServlet");

        resp.sendRedirect(req.getContextPath()+"/findUserByPageServlet");
    }
}
