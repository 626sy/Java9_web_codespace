package com.neusoft.service.impl;

import com.neusoft.dao.UserDao;
import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.domain.PageBean;
import com.neusoft.domain.User;
import com.neusoft.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author shihaobo
 * @date 2020/8/31 14:47
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        // 根据dao层查询
        return dao.findAll();
    }
    // 注册新用户
    @Override
    public void insertAll(User user) {
        dao.insertAll(user);
    }
    // 更新信息
    @Override
    public void update(User user) {
        dao.updateAll(user);
    }
    // 删除信息
    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }
    // 根据id查询并返回id
    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }
    // 登录1
    @Override
    public User login1(User user) {
        return dao.login(user);
    }
    // 登录
    @Override
    public User lgoin(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }


    @Override
    public void delSelectUser(String[] ids) {
        // 根据id批量删除数据
        if (ids!=null && ids.length>0){
            for (String id:ids) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public List<User> likeFind(User user) {
        return dao.likeFind(user);
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <=0){
            currentPage = 1;
        }
        // 创建 PageBean对象
        PageBean<User> pb = new PageBean<>();
        // 设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        // 调用 dao 的 查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        // 调用 dao 的分页查询
        int start = (currentPage-1)*rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);
        // 计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);


        return null;
    }
}
