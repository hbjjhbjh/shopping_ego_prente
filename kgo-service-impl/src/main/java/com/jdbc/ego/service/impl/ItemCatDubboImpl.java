package com.jdbc.ego.service.impl;

import com.jdbc.ego.mapper.TbItemCatMapper;
import com.jdbc.ego.pojo.TbItemCat;
import com.jdbc.ego.pojo.TbItemCatExample;
import com.kgo.dubbo.service.ItemCatDubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemCatDubboImpl implements ItemCatDubboService {
    //需要数据访问层的接口对象
    @Resource
    private TbItemCatMapper tbItemCatMapper;


    @Override
    public List<TbItemCat> showCatTGZ(long pid) {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        //用方法参数作为条件查询方法
        tbItemCatExample.createCriteria().andParentIdEqualTo(pid);
        return tbItemCatMapper.selectByExample(tbItemCatExample);
    }
}
