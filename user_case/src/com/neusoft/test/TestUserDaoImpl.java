package com.neusoft.test;

import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.domain.User;
import org.junit.Test;

import java.util.List;

/**
 * @author shihaobo
 * @date 2020/8/31 15:11
 */
public class TestUserDaoImpl {
    @Test
    public void userDaoImplTest(){
//        UserDaoImpl dao = new UserDaoImpl();
//        List<User> users = dao.findAll();
//        for (User user:users){
//            System.out.println(user);
//        }
        User user = new User();
        UserDaoImpl userDao = new UserDaoImpl();
        user.setName("lisi");
        user.setGender("男");
        user.setAge(12);
        user.setAddress("shenyang");
        user.setQq("22222");
        user.setEmail("sdfsdfsdf@qq.com");
        int i = userDao.insertAll(user);
        System.out.println(i);
    }
}
