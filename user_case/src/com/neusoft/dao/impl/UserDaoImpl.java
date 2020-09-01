package com.neusoft.dao.impl;

import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;
import com.neusoft.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @author shihaobo
 * @date 2020/8/31 14:45
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        // query():查询结果，将结果封装为JavaBean对象 * query的参数：RowMapper
        // * 一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装  new BeanPropertyRowMapper<类型>(类型.class)
//        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
//        return users;
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }
    // 修改
    @Override
    public List<User> updateAll() {
        String sql = "update user set name = ? and gender =? and age = ? and address = ? and qq = ? and email = ?";
        return null;
    }
    // 注册
    @Override
    public int insertAll(User user) {
        String sql = "insert into user values(null ,?,?,?,?,?,?)";
        int updateUser = template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail());
        return updateUser;
    }


}
