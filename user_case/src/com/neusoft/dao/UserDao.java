package com.neusoft.dao;

import com.neusoft.domain.User;

import java.util.List;

/**
 * @author shihaobo
 * @date 2020/8/31 14:41
 */
public interface UserDao {
    // 用户操作dao
    // 查询用户信息
    public List<User> findAll();

    // 注册
    public void insertAll(User user);

    public void updateAll(User user);

    public void delete(int id);

    public User findById(int id);
}
