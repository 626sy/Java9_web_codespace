package com.neusoft.dao.impl;

import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;
import com.neusoft.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public List<User> likeFind(User user) {
        String sql = "select * from user where"+" name like ? and address like ? and email like ?";
//        and address like '%?%' and email like '%?%'

        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), user.getName(), user.getAddress(), user.getEmail());
        return users;

    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        // 遍历map
        Set<String> keySet = condition.keySet();
        // {name : "李" , address :"广"   email = "111"}
        List<Object> params = new ArrayList<>();
        for (String key :keySet) {
            // 排除 分页的条件参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
//          select count(*) from user where 1=1 and name like '%李%'
            // 获取value值
            String value = condition.get(key)[0];
            // 判断value是否有值
            if (value != null && !"".equals(value)){
                sb.append("  and "+ key +" like ?  ");
                params.add("%" + value+"%");
            }
        }

        System.out.println("sql findTotalCount" +sb.toString());
        System.out.println(params);

//        return template.queryForObject(sb.toString(), Integer.class);
        return template.queryForObject(sb.toString(), Integer.class,params.toArray());
    }


    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {

        String sql = "select * from user where 1=1";
//        String sql = "select * from user limit ?,?";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();

        List<Object> params = new ArrayList<>();

        for (String key :keySet) {
            // 排除 分页的条件参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
//          select count(*) from user where 1=1 and name like '%李%'
            // 获取value值
            String value = condition.get(key)[0];
            // 判断value是否有值
            if (value != null && !"".equals(value)){
                sb.append("  and "+ key +" like ?  ");
                params.add("%" + value+"%");
            }
        }

        // 添加分页
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println("sqlfindByPage "+sql);
        System.out.println("params"+params);

        return template.query(sql, new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
