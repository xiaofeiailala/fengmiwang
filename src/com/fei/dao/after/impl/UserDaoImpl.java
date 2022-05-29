package com.fei.dao.after.impl;

import com.fei.bean.User;
import com.fei.dao.after.UserDao;
import com.fei.utils.BaseDao;
import com.fei.utils.JDBCDruidUtils;

import java.sql.Connection;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private BaseDao baseDao = new BaseDao();

    @Override
    public List<User> selectAll(String sqlPart,int pageNo,int pageSize) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select * from t_user  where 1 = 1 " + sqlPart + "limit ?,?";
        //System.out.println(sql);
        List<User> users = baseDao.select(connection, User.class, sql,pageNo,pageSize);
        JDBCDruidUtils.close(connection);
        return users;
    }

    @Override
    public long selectCount(String sqlPart) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select count(*) from t_user  where 1 = 1 " + sqlPart;

        long count = baseDao.selectCount(connection, sql);
        JDBCDruidUtils.close(connection);
        return count;
    }

    @Override
    public int addOne(User user) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "insert into t_user (username,password,phone,mail) values(?,?,?,?)";
        int update = baseDao.update(connection, sql, user.getUsername(), user.getPassword(), user.getPhone(), user.getMail());
        JDBCDruidUtils.close(connection);
        return update;
    }

    @Override
    public int deleteById(int id) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "delete from t_user where id = ?";
        int update = baseDao.update(connection, sql, id);
        JDBCDruidUtils.close(connection);
        return update;
    }

    @Override
    public int updateById(int id, String password) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "update t_user set password = ? where id = ?";
        int update = baseDao.update(connection, sql, password,id);
        JDBCDruidUtils.close(connection);
        return update;
    }


}
