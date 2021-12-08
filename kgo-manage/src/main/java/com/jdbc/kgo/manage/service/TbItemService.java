package com.jdbc.kgo.manage.service;


import com.ego.commons.pojo.EasyUIDataGrid;


public interface TbItemService {
    /*
    * 显示商品信息
    * */
    EasyUIDataGrid showInfo(int page, int rows);

    /*
    * 删除商品信息（逻辑删除）
    * */
    int updateStatusXFZ(String ids,byte status);

}
