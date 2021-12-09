package com.kgo.dubbo.service;


import com.jdbc.ego.pojo.TbItemCat;

import java.util.List;

public interface ItemCatDubboService {

    /*
    * 查询“商品类目表” 的提供者接口
    * */
    List<TbItemCat> showCatTGZ(long pid);
}
