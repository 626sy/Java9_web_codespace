package com.neusoft.dao;

import com.neusoft.domain.User;

import java.sql.SQLException;

/**
 * @author shihaobo
 * @date 2020/8/29 16:20
 */
public interface UserDao {
    public User Login(User Username) throws SQLException;
}
