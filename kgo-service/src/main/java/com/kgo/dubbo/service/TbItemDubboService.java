package com.kgo.dubbo.service;


import com.ego.commons.pojo.EasyUIDataGrid;
import com.jdbc.ego.pojo.TbItem;
import com.jdbc.ego.pojo.TbItemDesc;

/**
 * �ṩ������Ŀ�Ľӿ�
 */
public interface TbItemDubboService {
    //����
    int insertItemAndItemDesc(TbItem item, TbItemDesc desc) throws Exception;

    //ɾ��
    int updateTbItem(TbItem tbItem);

    //�޸�


    //��ѯ
    EasyUIDataGrid showByProvider(int page, int rows);

}
