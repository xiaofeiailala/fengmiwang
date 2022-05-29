package com.fei.service.after;

import com.fei.bean.Order;

import java.util.List;

public interface OrderService {
    List<Order> orderQuery(String pageNo);

    long orderCount();
}
