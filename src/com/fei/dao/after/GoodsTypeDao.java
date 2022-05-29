package com.fei.dao.after;

import com.fei.bean.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    List<GoodsType> selectAll(int pageNo,int pageSize);
    long selectCount();
    int add(GoodsType goodsType);
    int update(GoodsType goodsType);
    int delete(int id);
    GoodsType selectById(int id);
    List<GoodsType> selectAll();
}
