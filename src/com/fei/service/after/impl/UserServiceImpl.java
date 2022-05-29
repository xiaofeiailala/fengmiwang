package com.fei.service.after.impl;

import com.fei.bean.User;
import com.fei.dao.after.UserDao;
import com.fei.dao.after.impl.UserDaoImpl;
import com.fei.service.after.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao= new UserDaoImpl();

    @Override
    public List<User> queryUsers(String pageNo,String username,String sex){
       // List<User> users = userDao.selectAll();
       // return users;
        int pageNo1 = 1;
        if (pageNo != null){
            pageNo1 = Integer.parseInt(pageNo);
        }

        StringBuffer sql = new StringBuffer();
        if (username != null && username != ""){
            sql.append("and username like '%" + username + "%' ");
        }
        if (sex != null && sex != ""){
            sql.append("and sex like '%" + sex + "%' ");
        }
        String sqlPart = new String(sql);
        List<User> users = userDao.selectAll(sqlPart, (pageNo1 - 1)*5, 5);
        return users;
    }

    @Override
    public long userCount(String username, String sex) {

        StringBuffer sql = new StringBuffer();
        if (username != null && username != ""){
            sql.append("and username like '%" + username + "%' ");
        }
        if (sex != null && sex != ""){
            sql.append("and sex like '%" + sex + "%' ");
        }
        String sqlPart = new String(sql);
        long count = userDao.selectCount(sqlPart);
        return count % 5 == 0 ? count / 5 : count / 5 + 1;
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addOne(user) > 0 ? true : false;
    }

    @Override
    public boolean deleteUser(int id) {
        return userDao.deleteById(id) > 0 ? true : false;
    }

    @Override
    public boolean updatePassword(String password, int id) {
        return userDao.updateById(id,password) > 0 ? true : false;
    }
}
