package com.jdbc.kgo.manage.controller;

import com.ego.commons.pojo.EasyUiTree;
import com.jdbc.kgo.manage.service.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ItemCatController {
    //需要业务逻辑层接口对象调用查询方法
    @Resource
    private ItemCatService itemCatService;


    /*
    * @RequestParam(defaultValue = "0")默认值为0 默认一级菜单
    * */
    @RequestMapping("item/cat/list")
    @ResponseBody
    public List<EasyUiTree> showCat(@RequestParam(defaultValue="0") long id){
        return itemCatService.showCat(id);
    }

}
