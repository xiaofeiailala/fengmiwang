package com.fei.service.after.impl;

import com.fei.bean.Order;
import com.fei.dao.after.OrderDao;
import com.fei.dao.after.impl.OrderDaoImpl;
import com.fei.service.after.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private int pageSize = 5;
    @Override
    public List<Order> orderQuery(String pageNo) {
        int pageNo1 = 1;
        if (pageNo != null){
            pageNo1 = Integer.parseInt(pageNo);
        }
        List<Order> orders = orderDao.selectAll((pageNo1 - 1) * pageSize, pageSize);
        return orders;
    }

    @Override
    public long orderCount() {
        long count = orderDao.selectCount();
        return count % pageSize == 0 ? count / pageSize : count / pageSize +1;
    }
}
