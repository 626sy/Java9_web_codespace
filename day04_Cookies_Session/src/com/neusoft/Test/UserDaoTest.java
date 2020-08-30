package com.neusoft.Test;

import com.neusoft.dao.Impl.UserDaoImpl;
import com.neusoft.domain.User;
import org.junit.Test;

/**
 * @author shihaobo
 * @date 2020/8/29 20:10
 */
public class UserDaoTest {
    @Test
    public void test(){
        User user = new User();
        user.setPassword("123");
        user.setUsername("zhangsan");
        UserDaoImpl userDao = new UserDaoImpl();
        User login = userDao.Login(user);
        System.out.println(login);
    }
}
