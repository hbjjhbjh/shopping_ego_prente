package com.kgo.portal.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.utils.JsonUtils;
import com.jdbc.ego.pojo.TbContent;
import com.kgo.dubbo.service.TbContentDubboService;
import com.kgo.portal.service.TbContentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbContentServiceImpl implements TbContentService {

    //需要提供者接口
    @Reference
    private TbContentDubboService tbContentDubboService;


    @Override
    public String showPicSel() {
        //东西已经查出来了，看前台需要返回什么格式的数据
        List<TbContent> list = tbContentDubboService.selPic(6, true);
        List<Map<String,Object>> mapList = new ArrayList<>();
        //此处需要将查询出来的数据进行处理，list以前台需要的格式传递过去
        for (TbContent tbContent: list) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("srcB",tbContent.getPic2());
            map.put("height",240);
            map.put("alt","图片加载失败");
            map.put("width",670);
            map.put("src",tbContent.getPic());
            map.put("widthB",550);
            map.put("href",tbContent.getUrl());
            map.put("heightB",240);
            mapList.add(map);
        }
        return JsonUtils.objectToJson(mapList);
    }
}
