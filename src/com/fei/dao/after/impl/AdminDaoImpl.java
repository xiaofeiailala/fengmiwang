package com.fei.dao.after.impl;

import com.fei.bean.Admin;
import com.fei.dao.after.AdminDao;
import com.fei.utils.JDBCDruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    //private BaseDao baseDao = new BaseDao();
    public AdminDaoImpl(){

    }
    @Override
    public Admin selectByNameAndPassword(String username, String password) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select * from admin where username = ? and password = ?";
        QueryRunner runner = new QueryRunner();
        try {
            Admin admin = runner.query(connection, sql, new BeanHandler<>(Admin.class), username, password);
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCDruidUtils.close(connection);
        }
        return null;
    }
}
