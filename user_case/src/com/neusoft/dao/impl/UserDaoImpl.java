package com.neusoft.dao.impl;

import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;
import com.neusoft.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
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

    // 注册
    @Override
    public void insertAll(User user) {
        String sql = "insert into user values(null ,?,?,?,?,?,?,null,null)";
        int addUser = template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail());
        System.out.println(addUser);

    }
    // 根据id修改更新信息
    @Override
    public void updateAll(User user) {
        // TODO
        String sql = "update user set name = ?,gender = ? ,age= ? ,address = ? ,qq = ? ,email = ? where id = ?" ;
        template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail(),user.getId());

    }
    // 删除信息
    @Override
    public void delete(int id) {
        String sql ="delete from user where id = ?";

        template.update(sql,id);
    }
    // 根据id查询并获取id
    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);

    }

    @Override
    public User login(User user) {
        String sql = "select * from user where username = ? and password = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),user.getUsername(),user.getPassword());

    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
