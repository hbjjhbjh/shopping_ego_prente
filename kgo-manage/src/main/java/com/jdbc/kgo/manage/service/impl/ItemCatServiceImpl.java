package com.jdbc.kgo.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUiTree;
import com.jdbc.ego.pojo.TbItemCat;
import com.jdbc.kgo.manage.service.ItemCatService;
import com.kgo.dubbo.service.ItemCatDubboService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    //需要提供者中的接口对象
    @Reference
    private ItemCatDubboService itemCatDubbo;


    @Override
    public List<EasyUiTree> showCat(long pid) {
        List<TbItemCat> tbItemCats = itemCatDubbo.showCatTGZ(pid);
        ArrayList<EasyUiTree> easyUiTrees = new ArrayList<>();
        for (TbItemCat itemCat: tbItemCats) {
            EasyUiTree tree = new EasyUiTree();
            tree.setId(itemCat.getId());
            tree.setText(itemCat.getName());
            tree.setState(itemCat.getIsParent()?"closed":"open");

            easyUiTrees.add(tree);
        }
        return easyUiTrees;
    }
}
