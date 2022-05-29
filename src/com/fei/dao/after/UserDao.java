package com.fei.dao.after;

import com.fei.bean.User;

import java.util.List;

public interface UserDao {
    List<User> selectAll(String sqlPart,int pageNo,int pageSize);

    long selectCount(String sqlPart);

    int addOne(User user);

    int deleteById(int id);

    int updateById(int id,String password);
}
