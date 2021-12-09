package com.kgo.dubbo.service;

import com.jdbc.ego.pojo.TbContent;

import java.util.List;

public interface TbContentDubboService {
    /*
    * 查询图片路径
    * 显示图片数量
    *是否需要排序
    * */
    List<TbContent> selPic(int content,boolean isSort);
}
