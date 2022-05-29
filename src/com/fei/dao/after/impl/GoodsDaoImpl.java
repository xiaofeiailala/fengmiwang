package com.fei.dao.after.impl;

import com.fei.bean.Goods;
import com.fei.dao.after.GoodsDao;
import com.fei.utils.BaseDao;
import com.fei.utils.JDBCDruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {

    private BaseDao baseDao = new BaseDao();

    @Override
    public List<Goods> selectAll(String sqlPart,int pageNo,int pageSize) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select t2.id,t2.goodsName,t2.price,t2.score,t2.deployDate,t2.imgPath,t2.`comment`,t1.typeName from t_goods t2 " +
                "JOIN t_goodstype t1 ON t1.id = t2.typeId where 1=1 " + sqlPart + " limit ?,?";
        System.out.println(sql);
        List<Goods> goodsList = baseDao.select(connection, Goods.class, sql, pageNo, pageSize);
        JDBCDruidUtils.close(connection);
        return goodsList;
    }

    @Override
    public long selectCount() {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select count(*) from t_goods";
        long count = baseDao.selectCount(connection,sql);
        JDBCDruidUtils.close(connection);
        return count;
    }

    @Override
    public int add(Goods goods, Date date) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "insert into t_goods (goodsName,price,typeId,imgPath,`comment`,deployDate) values(?,?,?,?,?,?);";
        int update = baseDao.update(connection, sql, goods.getGoodsName(), goods.getPrice(), goods.getTypeId(), goods.getImgPath(), goods.getComment(),date);
        JDBCDruidUtils.close(connection);
        return update;
    }

    @Override
    public int update(Goods goods) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "update t_goods set goodsName = ?,price = ?,typeId = ?,imgPath = ?,`comment` = ? where id = ?";
        int update = baseDao.update(connection, sql, goods.getGoodsName(), goods.getPrice(), goods.getTypeId(), goods.getImgPath(), goods.getComment(), goods.getId());
        JDBCDruidUtils.close(connection);
        return update;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public Goods selectById(int id) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select t2.id,t2.goodsName,t2.price,t2.score,t2.deployDate,t2.imgPath,t2.`comment`,t1.typeName,t2.typeId from t_goods t2 JOIN t_goodstype t1 ON t1.id = t2.typeId where t2.id = ?";
        QueryRunner runner = new QueryRunner();
        try {
            Goods goods = runner.query(connection, sql, new BeanHandler<>(Goods.class), id);
            return goods;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCDruidUtils.close(connection);
        }
        return null;
    }
}
