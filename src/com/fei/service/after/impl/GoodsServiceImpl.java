package com.fei.service.after.impl;

import com.fei.bean.Goods;
import com.fei.dao.after.GoodsDao;
import com.fei.dao.after.impl.GoodsDaoImpl;
import com.fei.service.after.GoodsService;

import java.sql.Date;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao = new GoodsDaoImpl();
    private int pageSize = 10;

    @Override
    public List<Goods> queryAll(String pageNo,String goodsName,String deployDate,String typeId) {
        int pageNo1 = 1;
        if (pageNo != null){
            pageNo1 = Integer.parseInt(pageNo);
        }
        StringBuffer sqlPart = new StringBuffer();
        if (goodsName != null && goodsName != ""){
            sqlPart.append(" and t2.goodsName like '%" + goodsName + "%'");
        }
        if (deployDate != null && deployDate != ""){

            sqlPart.append(" and t2.deployDate = '" + deployDate + "'");
        }
        if (typeId != null && typeId != ""){
            sqlPart.append(" and t2.typeId = '" + typeId + "'");
        }
        List<Goods> goodsList = goodsDao.selectAll(new String(sqlPart),(pageNo1 - 1) * pageSize, pageSize);

        return goodsList;
    }

    @Override
    public long goodsCount() {

        long count = goodsDao.selectCount();

        return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    @Override
    public boolean goodsUpdate(Goods goods) {
        int update = goodsDao.update(goods);
        return update > 0 ? true : false;
    }

    @Override
    public boolean goodsAdd(Goods goods) {
        int update = goodsDao.add(goods,new Date(new java.util.Date().getTime()));
        return update > 0 ? true : false;
    }

    @Override
    public Goods goodsById(int id) {
        Goods goods = goodsDao.selectById(id);

        return goods;
    }
}
