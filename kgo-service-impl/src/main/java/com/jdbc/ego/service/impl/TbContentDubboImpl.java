package com.jdbc.ego.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jdbc.ego.mapper.TbContentMapper;
import com.jdbc.ego.pojo.TbContent;
import com.jdbc.ego.pojo.TbContentExample;
import com.kgo.dubbo.service.TbContentDubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
* 查询图片的提供者
* */
public class TbContentDubboImpl implements TbContentDubboService {

    @Resource
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> selPic(int content, boolean isSort) {
        TbContentExample tbContentExample = new TbContentExample();
        if (isSort){
            tbContentExample.setOrderByClause("updated desc");
        }
        if (content != 0){//不等于0的时候
            //排序
            PageHelper.startPage(1,content);
            List<TbContent> tbContents = tbContentMapper.selectByExampleWithBLOBs(tbContentExample);
            PageInfo<TbContent> tbContentPageInfo = new PageInfo<>(tbContents);
            List<TbContent> list = tbContentPageInfo.getList();
            //查询数据所有图片路径排序结果，并且以每页的形式显示到前台
            return list;
        }else {
            //如果只有一张就不用排序了
            return tbContentMapper.selectByExampleWithBLOBs(tbContentExample);
        }
    }
}
