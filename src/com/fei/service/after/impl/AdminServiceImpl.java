package com.fei.service.after.impl;


import com.fei.bean.Admin;
import com.fei.dao.after.AdminDao;
import com.fei.dao.after.impl.AdminDaoImpl;
import com.fei.service.after.AdminService;

public class AdminServiceImpl implements AdminService {

    public AdminDao adminDao = new AdminDaoImpl();

    public boolean login(String username,String password){
        Admin admin = adminDao.selectByNameAndPassword(username, password);
        return admin != null ? true : false;
    }
}
