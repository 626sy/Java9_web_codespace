package com.neusoft.dao;

import com.neusoft.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author shihaobo
 * @date 2020/8/31 14:41
 */
public interface UserDao {
    // 用户操作dao
    // 查询用户信息
    public List<User> findAll();

    // 注册信息
    public void insertAll(User user);
    // 更新信息
    public void updateAll(User user);
    // 删除信息
    public void delete(int id);
    // 根据id查询并获取id
    public User findById(int id);
    // 登录
    public User login(User user);

    public User findUserByUsernameAndPassword(String username,String password);

    List<User> likeFind(User user);

    // 查询总记录数
    int findTotalCount(Map<String, String[]> condition);
    // 分页查询每页记录
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
