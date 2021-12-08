package com.jdbc.kgo.manage.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface PicService {

    /*
    * 上传图片功能
    * */
    Map<String,Object> uploadInfo(MultipartFile uploadFile) throws IOException;
}
