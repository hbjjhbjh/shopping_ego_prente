package com.jdbc.ego.service.impl;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jdbc.ego.mapper.TbItemMapper;
import com.jdbc.ego.pojo.TbItem;
import com.jdbc.ego.pojo.TbItemExample;
import com.kgo.dubbo.service.TbItemDubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbItemDubboServiceImpl implements TbItemDubboService {

    @Resource
    private TbItemMapper tbItemMapper;

    /*
     * 删除商品信息（逻辑删除）
     * */
    public int updateTbItem(TbItem tbItem) {
        return tbItemMapper.updateByPrimaryKeySelective(tbItem);
    }

    /*
     * 显示商品信息
     * */
    public EasyUIDataGrid showByProvider(int page, int rows) {
        System.out.println("66666");
        PageHelper.startPage(page, rows);
        TbItemExample example = new TbItemExample();
        //从数据库中查询的数据
        List<TbItem> list = tbItemMapper.selectByExample(example);
        PageInfo<TbItem> pi = new PageInfo(list);
        EasyUIDataGrid dg = new EasyUIDataGrid();
        dg.setRows(pi.getList());
        dg.setTotal(pi.getTotal());
        System.out.println("77777777");
        return dg;
    }
}
