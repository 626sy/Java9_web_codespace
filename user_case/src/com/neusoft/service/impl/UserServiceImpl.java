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

    @Override
    public int insertAll(User user) {
        return dao.insertAll(user);
    }
}
