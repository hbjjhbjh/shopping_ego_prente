package com.jdbc.kgo.manage.controller;

import com.jdbc.kgo.manage.service.PicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class PicController {

    //需要业务逻辑层接口对象
    @Resource
    private PicService picService;

    @RequestMapping("pic/upload")
    @ResponseBody
    public Map<String,Object> uploadPic(MultipartFile uploadFile){
        //通过业务逻辑层接口调用上传图片的方法
        System.out.println(uploadFile.getName());
        Map<String, Object> map = picService.uploadInfo(uploadFile);
        return map;
    }
}