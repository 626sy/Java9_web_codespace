package com.neusoft.dao;

import com.neusoft.domain.User;

import java.util.List;

/**
 * @author shihaobo
 * @date 2020/8/31 14:41
 */
public interface UserDao {
    // 用户操作dao
    public List<User> findAll();


}
