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
    // 修改
    public List<User> updateAll();
    // 注册
    public int insertAll(User user);
}
