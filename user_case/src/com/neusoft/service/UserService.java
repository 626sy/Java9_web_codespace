package com.neusoft.service;

import com.neusoft.domain.User;

import java.util.List;

/**
 * 用户管理业务接口
 */




public interface UserService {
    // 查询所有用户信息
    public List<User> findAll();

    // 注册新用户
    public void insertAll(User user);
    // 更新信息
    public void update(User user);
    // 删除信息
    public void deleteUser(String  id);
    // 根据id查询并返回id
    public User findUserById(String id);
    // 登录
    public User login1(User user);

    User lgoin(User user);
}
