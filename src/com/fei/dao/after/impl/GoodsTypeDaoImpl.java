package com.fei.dao.after.impl;

import com.fei.bean.GoodsType;
import com.fei.dao.after.GoodsTypeDao;
import com.fei.utils.BaseDao;
import com.fei.utils.JDBCDruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GoodsTypeDaoImpl implements GoodsTypeDao {

    private BaseDao baseDao = new BaseDao();

    @Override
    public List<GoodsType> selectAll(int pageNo,int pageSize) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select * from t_goodstype limit ?,?";
        List<GoodsType> goodsTypes = baseDao.select(connection, GoodsType.class, sql, pageNo, pageSize);
        JDBCDruidUtils.close(connection);
        return goodsTypes;
    }

    @Override
    public long selectCount() {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select count(*) from t_goodstype";
        long count = baseDao.selectCount(connection,sql);
        JDBCDruidUtils.close(connection);
        return count;
    }

    @Override
    public int add(GoodsType goodsType) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "insert into t_goodstype (typeName) values(?)";
        int update = baseDao.update(connection, sql, goodsType.getTypeName());
        JDBCDruidUtils.close(connection);
        return update;
    }

    @Override
    public int update(GoodsType goodsType) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "update t_goodstype set typeName = ? where id = ?";
        int update = baseDao.update(connection, sql, goodsType.getTypeName(),goodsType.getId());
        JDBCDruidUtils.close(connection);
        return update;
    }

    @Override
    public int delete(int id) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "delete from t_goodstype where id = ?";
        int update = baseDao.update(connection, sql, id);
        JDBCDruidUtils.close(connection);
        return update;
    }

    @Override
    public GoodsType selectById(int id) {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select * from t_goodstype where id = ?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            GoodsType goodsType = queryRunner.query(connection, sql, new BeanHandler<>(GoodsType.class), id);
            return goodsType;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCDruidUtils.close(connection);
        }
        return null;
    }

    @Override
    public List<GoodsType> selectAll() {
        Connection connection = JDBCDruidUtils.connection();
        String sql = "select * from t_goodstype";
        List<GoodsType> goodsTypes = baseDao.select(connection, GoodsType.class, sql);
        JDBCDruidUtils.close(connection);
        return goodsTypes;
    }
}
