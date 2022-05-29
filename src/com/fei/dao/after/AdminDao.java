package com.fei.dao.after;

import com.fei.bean.Admin;

public interface AdminDao {
    Admin selectByNameAndPassword(String username,String password);
}
