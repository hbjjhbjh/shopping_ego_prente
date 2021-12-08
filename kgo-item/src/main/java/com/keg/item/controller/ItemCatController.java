package com.keg.item.controller;

import com.keg.item.service.ItemCatServiceXFZ;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ItemCatController {
    //拿到业务逻辑层接口对象
    @Resource
    private ItemCatServiceXFZ itemCatServiceXFZ;

    //查询--显示各个级别菜单方法
    /*
    * 需要通过Jsonp,作为“跨域请求”
    *
    * MappingJacksonValue:该类可以实现跨域请求（由一个项目请求另外一个项目的数据）
    * 同时又可以把结果以json串的形式放回到前台
    * */
    @RequestMapping("rest/itemcat/all")
    @ResponseBody
    public MappingJacksonValue showCatMenu(String callback){
        //调用业务逻辑层的方法
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(itemCatServiceXFZ.showMenuInfo());
        //把查询出来的数据，以“回调函数” 的形式返还给页面
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
