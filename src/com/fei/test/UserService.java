package com.fei.test;

import com.fei.bean.Goods;
import com.fei.bean.GoodsType;
import com.fei.bean.Order;
import com.fei.bean.User;
import com.fei.dao.after.GoodsTypeDao;
import com.fei.dao.after.impl.GoodsTypeDaoImpl;
import com.fei.dao.after.impl.OrderDaoImpl;
import com.fei.dao.after.impl.UserDaoImpl;
import com.fei.service.after.GoodsService;
import com.fei.service.after.impl.GoodsServiceImpl;
import com.fei.service.after.impl.GoodsTypeServiceImpl;
import com.fei.service.after.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserService {
    @Test
    public void test1(){
        UserServiceImpl userService = new UserServiceImpl();
        //long users = userService.userCount("1", null, null);
        //System.out.println(users);
//        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
//        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
//        GoodsType goodsType = goodsTypeService.goodsTypeById("1");
//        System.out.println(goodsType);
//        GoodsService gs=new GoodsServiceImpl();
//        Goods goods = gs.goodsById(41);
//        System.out.println(goods);
        OrderDaoImpl orderDao = new OrderDaoImpl();

        List<Order> orders = orderDao.selectAll(0, 5);
        System.out.println(orders);
    }

}
