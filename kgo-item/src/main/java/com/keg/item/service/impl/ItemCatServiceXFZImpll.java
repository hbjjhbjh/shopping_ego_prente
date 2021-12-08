package com.keg.item.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jdbc.ego.pojo.TbItemCat;
import com.keg.item.pojo.PortalMenu;
import com.keg.item.pojo.PortalMenuNode;
import com.keg.item.service.ItemCatServiceXFZ;
import com.kgo.dubbo.service.ItemCatDubbo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ItemCatServiceXFZImpll implements ItemCatServiceXFZ {
    /*
    * 需要来自提供者的接口对象
    * */
    @Reference
    private ItemCatDubbo itemCatDubbo;

    @Override
    public PortalMenu showMenuInfo() {
        List<TbItemCat> list = itemCatDubbo.showCatTGZ(0);
        PortalMenu portalMenu = new PortalMenu();
        portalMenu.setData(selAllMenus(list));
        return portalMenu;
    }
    //递归：自己调用自己（子查询）
    public List<Object> selAllMenus(List<TbItemCat> list){
        ArrayList<Object> objects = new ArrayList<>();
        for (TbItemCat  tbItemCat: list) {
            if (tbItemCat.getIsParent()){

                PortalMenuNode portalMenuNode = new PortalMenuNode();

                portalMenuNode.setU("/products/"+tbItemCat.getId()+".html");

                portalMenuNode.setN("\"<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>\"");

                portalMenuNode.setI(selAllMenus(itemCatDubbo.showCatTGZ(tbItemCat.getId())));

                objects.add(portalMenuNode);
            }else {
                //如果不是父菜单属于直接查询，不需要递归调用自己
                boolean add = objects.add("/products/" + tbItemCat.getId() + ".html|"+tbItemCat.getName());
            }
        }
        return objects;
    }
}
