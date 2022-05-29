package com.fei.service.after;

import com.fei.bean.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsType> goodsTypes(String pageNo);
    long goodsTypeCount();

    boolean goodsTypeAdd(GoodsType goodsType);
    boolean goodsTypeUpdate(GoodsType goodsType);
    boolean goodsTypeDelete(String id);
    GoodsType goodsTypeById(String id);

    List<GoodsType> selectAll();
}
