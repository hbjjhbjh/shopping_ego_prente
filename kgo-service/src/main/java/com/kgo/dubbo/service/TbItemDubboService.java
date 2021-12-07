package com.kgo.dubbo.service;


import com.ego.commons.pojo.EasyUIDataGrid;
import com.jdbc.ego.pojo.TbItem;

/**
 * 提供者子项目的接口
 */
public interface TbItemDubboService {
    //增加


    //删除
    int updateTbItem(TbItem tbItem);

    //修改


    //查询
    EasyUIDataGrid showByProvider(int page, int rows);

}
