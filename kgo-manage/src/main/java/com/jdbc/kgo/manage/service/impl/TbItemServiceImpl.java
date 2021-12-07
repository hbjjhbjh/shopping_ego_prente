package com.jdbc.kgo.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.jdbc.ego.pojo.TbItem;
import com.jdbc.kgo.manage.service.TbItemService;
import com.kgo.dubbo.service.TbItemDubboService;
import org.springframework.stereotype.Service;

@Service
public class TbItemServiceImpl implements TbItemService {

    @Reference
    public TbItemDubboService tbItemDubboService;

    /*
     * 显示商品信息
     * */
    @Override
    public EasyUIDataGrid showInfo(int page, int rows) {
        EasyUIDataGrid easyUIDataGrid = tbItemDubboService.showByProvider(page, rows);
        return easyUIDataGrid;
    }
    /*
     * 删除商品信息（逻辑删除）
     * */
    @Override
    public int updateStatusXFZ(String ids, byte status) {
        int index = 0;
        TbItem tbItem = new TbItem();
        String[] split = ids.split(",");
        for (String id:split) {
            tbItem.setId(Long.parseLong(id));
            tbItem.setStatus(status);
            index +=tbItemDubboService.updateTbItem(tbItem);
        }
        if (index == split.length){
            return 1;
        }
        return 0;
    }
}
