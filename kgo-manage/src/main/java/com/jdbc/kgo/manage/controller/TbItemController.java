package com.jdbc.kgo.manage.controller;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.jdbc.kgo.manage.service.TbItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TbItemController {
    @Resource
    private TbItemService tbItemService;

    //商品下架商品的方法
    @RequestMapping("rest/item/instock")
    @ResponseBody
    public EgoResult reshelfInfo(String ids){
        int index = tbItemService.updateStatusXFZ(ids,(byte)2);
        EgoResult egoResult = new EgoResult();
        if (index == 1){
            egoResult.setStatus(200);
        }
        return egoResult;
    }

    //商品上架商品的方法
    @RequestMapping("rest/item/reshelf")
    @ResponseBody
    public EgoResult xiaJiaInfo(String ids){
        int index = tbItemService.updateStatusXFZ(ids,(byte)1);
        EgoResult egoResult = new EgoResult();
        if (index == 1){
            egoResult.setStatus(200);
        }
        return egoResult;
    }

    //删除商品的方法
    @RequestMapping("rest/item/delete")
    @ResponseBody
    public EgoResult deleteInfo(String ids){
        int index = tbItemService.updateStatusXFZ(ids,(byte)3);
        EgoResult egoResult = new EgoResult();
        if (index == 1){
            egoResult.setStatus(200);
        }
        return egoResult;
    }
    //修改商品的方法

    //查询商品的方法
    @RequestMapping("item/list")
    @ResponseBody
    public EasyUIDataGrid showTbItem(int page, int rows){
        EasyUIDataGrid easyUIDataGrid = this.tbItemService.showInfo(page, rows);
        return  easyUIDataGrid;
    }
}
