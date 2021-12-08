package com.jdbc.kgo.manage.service;


import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.jdbc.ego.pojo.TbItem;


public interface TbItemService {
    /*
    * 显示商品信息
    * */
    EasyUIDataGrid showInfo(int page, int rows);

    /*
    * 删除商品信息（逻辑删除）
    * */
    int updateStatusXFZ(String ids,byte status);

    /*
     * 新增商品信息
     * */
    int insertInto(TbItem item, String desc) throws Exception;

}
