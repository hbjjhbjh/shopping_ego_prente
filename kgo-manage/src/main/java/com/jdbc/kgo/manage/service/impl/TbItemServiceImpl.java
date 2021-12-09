package com.jdbc.kgo.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.utils.IDUtils;
import com.jdbc.ego.pojo.TbItem;
import com.jdbc.ego.pojo.TbItemDesc;
import com.jdbc.kgo.manage.service.TbItemService;
import com.kgo.dubbo.service.TbItemDubboService;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    /*
     * 新增商品信息
     * */
    @Override
    public int insertInto(TbItem item, String desc) throws Exception {
        Date date = new Date();
        long id = IDUtils.genItemId();
        //商品表
        item.setId(id);
        item.setStatus((byte) 1);
        item.setCreated(date);
        item.setUpdated(date);

        TbItemDesc tbItemDesc = new TbItemDesc();
        //商品描述表
        tbItemDesc.setItemId(id);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);

        int index = tbItemDubboService.insertItemAndItemDesc(item, tbItemDesc);
        return index;
    }
}
