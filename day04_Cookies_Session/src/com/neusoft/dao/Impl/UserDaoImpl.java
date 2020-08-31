package com.neusoft.dao.Impl;

import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;
import com.neusoft.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shihaobo
 * @date 2020/8/29 16:23
 */
public class UserDaoImpl implements UserDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    User user = null;
    @Override
    public User Login(User Username) {
        String sql = "select * from userlogin2 where username = ? and password = ?";

        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,Username.getUsername());
            pstmt.setString(2,Username.getPassword());
            rs = pstmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return user;
    }

    @Override
    public User register(User user) {
        String sql = "insert into userlogin2(username,password,gender) values (?,?,?)";
        int id = 0;
        User registerUser = new User();
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getGender());
            rs = pstmt.executeQuery();
            while (rs.next()){
                registerUser.setId(1);
                registerUser.setUsername(rs.getString("username"));
                registerUser.setPassword(rs.getString("password"));
                registerUser.setGender(rs.getString("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return registerUser;
    }
}
