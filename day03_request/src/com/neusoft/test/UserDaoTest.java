package com.neusoft.test;

import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.domain.User;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author shihaobo
 * @date 2020/8/28 11:00
 */
public class UserDaoTest {
    @Test
    public void testLogin() throws SQLException {
        User loginUser = new User();
        loginUser.setUsename("bigbaby");
        loginUser.setPassword("12345");

        UserDaoImpl dao = new UserDaoImpl();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
