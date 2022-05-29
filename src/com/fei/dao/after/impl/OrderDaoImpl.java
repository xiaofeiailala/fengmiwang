package com.fei.dao.after.impl;

import com.fei.bean.Goods;
import com.fei.bean.Order;
import com.fei.dao.after.OrderDao;
import com.fei.utils.BaseDao;
import com.fei.utils.JDBCDruidUtils;

import java.sql.Connection;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private BaseDao baseDao = new BaseDao();

    @Override
    public List<Order> selectAll(int pageNo,int pageSize) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select t1.id,t1.orderCode,t1.totalPrice,t3.order_status orderStatus,t1.createDate,t2.username " +
                "from t_order t1 join t_user t2 on t1.uid = t2.id join t_status t3 on t1.`status` = t3.id limit ?,? ";
        List<Order> orders = baseDao.select(connection, Order.class, sql, pageNo, pageSize);
        JDBCDruidUtils.close(connection);
        return orders;
    }

    @Override
    public long selectCount() {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select count(*) from t_order;";
        long count = baseDao.selectCount(connection, sql);
        JDBCDruidUtils.close(connection);
        return count;
    }


}
