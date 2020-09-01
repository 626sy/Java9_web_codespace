package com.neusoft.service.impl;

import com.neusoft.dao.UserDao;
import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.domain.User;
import com.neusoft.service.UserService;

import java.util.List;

/**
 * @author shihaobo
 * @date 2020/8/31 14:47
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        // 根据dao层查询
        return dao.findAll();
    }
    // 注册新用户
    @Override
    public void insertAll(User user) {
        dao.insertAll(user);
    }
    // 更新信息
    @Override
    public void update(User user) {
        dao.updateAll(user);
    }
    // 删除信息
    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }
    // 根据id查询并返回id
    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public User login1(User user) {
        return dao.login(user);
    }

    @Override
    public User lgoin(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
