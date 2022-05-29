package com.fei.service.after;

import com.fei.bean.User;

import java.util.List;

public interface UserService {
    List<User> queryUsers(String pageNo,String username,String sex);
    long userCount(String username,String sex);
    boolean addUser(User user);
    boolean deleteUser(int id);
    boolean updatePassword(String password,int id);
}
