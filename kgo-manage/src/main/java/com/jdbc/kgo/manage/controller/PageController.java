package com.jdbc.kgo.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 直接走根目录
     * @return
     */
    @RequestMapping("/")
    public String welcomeEgo(){
        return "index";
    }
    /**
     * 通过变量匹配所有jsp页面
     * @param wdyPage
     * @return
     */
    @RequestMapping("{wdyPage}")
    public String showPageInfo(@PathVariable("wdyPage") String wdyPage){
        return wdyPage;
    }
}
