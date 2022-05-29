package com.fei.service.after.impl;

import com.fei.bean.GoodsType;
import com.fei.dao.after.GoodsTypeDao;
import com.fei.dao.after.impl.GoodsTypeDaoImpl;
import com.fei.service.after.GoodsTypeService;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {

    private GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
    private int pageSize = 5;
    @Override
    public List<GoodsType> goodsTypes(String pageNo) {

        int pageNo1 = 1;
        if (pageNo != null){
            pageNo1 = Integer.parseInt(pageNo);
        }
        List<GoodsType> goodsTypes = goodsTypeDao.selectAll((pageNo1 - 1) * pageSize, pageSize);

        return goodsTypes;
    }

    @Override
    public long goodsTypeCount() {
        long count = goodsTypeDao.selectCount();
        return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    @Override
    public boolean goodsTypeAdd(GoodsType goodsType) {
        return goodsTypeDao.add(goodsType) > 0 ? true : false;
    }

    @Override
    public boolean goodsTypeUpdate(GoodsType goodsType) {
        return goodsTypeDao.update(goodsType) > 0 ? true : false;
    }

    @Override
    public boolean goodsTypeDelete(String id) {
        return goodsTypeDao.delete(Integer.parseInt(id)) > 0 ? true : false;
    }

    @Override
    public GoodsType goodsTypeById(String id) {
        GoodsType goodsType = goodsTypeDao.selectById(Integer.parseInt(id));
        return goodsType;
    }

    @Override
    public List<GoodsType> selectAll() {
        List<GoodsType> goodsTypes = goodsTypeDao.selectAll();
        return goodsTypes;
    }
}
