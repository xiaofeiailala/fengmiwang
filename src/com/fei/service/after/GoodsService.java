package com.fei.service.after;

import com.fei.bean.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> queryAll(String pageNo,String goodsName,String deployDate,String typeId);
    long goodsCount();

    boolean goodsUpdate(Goods goods);
    boolean goodsAdd(Goods goods);
    Goods goodsById(int id);
}
