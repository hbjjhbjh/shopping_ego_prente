package com.jdbc.kgo.manage.service.impl;

import com.ego.commons.utils.FtpUtil;
import com.jdbc.kgo.manage.service.PicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
public class PicServiceImpl implements PicService {

    @Value("${ftpclient.host}")
    private String host;
    @Value("${ftpclient.port}")
    private int port;
    @Value("${ftpclient.username}")
    private String username;
    @Value("${ftpclient.password}")
    private String password;
    @Value("${ftpclient.basePath}")
    private String basePath;
    @Value("${ftpclient.filePath}")
    private String filePath;

    /*
    * 上传图片
    * */
    @Override
    public Map<String, Object> uploadInfo(MultipartFile uploadFile) {
        String filename = uploadFile.getOriginalFilename();
        try {
            boolean uploadFile1 = FtpUtil.uploadFile(host, port, username, password, basePath, filePath, filename, uploadFile.getInputStream());
            System.out.println(host);
            System.out.println(port);
            System.out.println(username);
            System.out.println(password);
            System.out.println(basePath);
            System.out.println(filePath);
            System.out.println(filename);
            System.out.println(uploadFile.getInputStream());


            HashMap<String, Object> map = new HashMap<>();
            if (uploadFile1){
                map.put("error",1);
                map.put("url","http://"+host+"/"+filename);
            }else {
                map.put("error",0);
                map.put("message","错误信息：上传图片失败");
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
