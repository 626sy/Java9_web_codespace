package com.neusoft.test;

import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.domain.User;
import com.neusoft.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * @author shihaobo
 * @date 2020/8/31 15:11
 */
public class TestUserDaoImpl {
    // list
/*    @Test
    public void userDaoImplTest(){
        UserDaoImpl dao = new UserDaoImpl();
        List<User> users = dao.findAll();
        for (User user:users){
            System.out.println(user);
        }

    }*/
        // 注册
/*    @Test
    public void userDaoImplTest2(){
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
    }*/

//      注册
/*    @Test
    public void userDaoImplTest3() throws InvocationTargetException, IllegalAccessException {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age","12");
        User user = new User();
        BeanUtils.populate(user,map);
        System.out.println(user);
    }*/
        // 修改
/*    @Test
    public void userDaoImplTest4() throws InvocationTargetException, IllegalAccessException {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age","12");
        User user = new User();
        BeanUtils.populate(user,map);
        System.out.println(user);

    }*/

    @Test
    public void Test5()  {
        UserServiceImpl service = new UserServiceImpl();
        UserDaoImpl dao = new UserDaoImpl();
        User user = new User();

        service.likeFind(user);

    }

}
