package com.fei.dao.after;

import com.fei.bean.Goods;
import com.fei.bean.GoodsType;

import java.sql.Date;
import java.util.List;

public interface GoodsDao {
    List<Goods> selectAll(String sqlPart, int pageNo,int pageSize);

    long selectCount();

    int add(Goods goods, Date date);
    int update(Goods goods);
    int delete(int id);

    Goods selectById(int id);
}
