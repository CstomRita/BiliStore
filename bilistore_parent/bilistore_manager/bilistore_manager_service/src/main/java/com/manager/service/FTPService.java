package com.manager.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;


public interface FTPService {

    JSONObject uploadImage(MultipartFile multipartFile);
}
