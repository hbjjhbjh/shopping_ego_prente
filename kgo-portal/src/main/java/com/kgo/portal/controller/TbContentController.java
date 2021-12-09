package com.kgo.portal.controller;

import com.kgo.portal.service.TbContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
public class TbContentController {

    //需要业务逻辑层接口
    @Resource
    private TbContentService tbContentService;


    @RequestMapping("showBigPic")
    public String showBigPic(Model model){
        model.addAttribute("ad1",tbContentService.showPicSel());
        return "index";
    }
}
