package com.kgo.dubbo.service;


import com.ego.commons.pojo.EasyUIDataGrid;
import com.jdbc.ego.pojo.TbItem;

/**
 * �ṩ������Ŀ�Ľӿ�
 */
public interface TbItemDubboService {
    //����


    //ɾ��
    int updateTbItem(TbItem tbItem);

    //�޸�


    //��ѯ
    EasyUIDataGrid showByProvider(int page, int rows);

}
