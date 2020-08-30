package com.neusoft.dao.impl;

import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;
import com.neusoft.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shihaobo
 * @date 2020/8/28 13:13
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User login(User loginUser) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        User user = null;
        String sql = "select * from userlogin where username = ? and password = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,loginUser.getUsername());
            pstmt.setString(2,loginUser.getPassword());
            res = pstmt.executeQuery();
            while (res.next()){
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(res,pstmt,conn);
        }
        return user;
    }
}
