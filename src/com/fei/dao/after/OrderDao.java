package com.fei.dao.after;

import com.fei.bean.Order;

import java.util.List;

public interface OrderDao {

    List<Order> selectAll(int pageNo,int pageSize);

    long selectCount();
}
