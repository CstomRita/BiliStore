package com.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.manager.service.FTPService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:21 2018/9/26
 * @ Description：上传图片到FTP服务器
 * @ Modified By：
 * @Version: $
 */
@Controller
public class FTPController {

    @Autowired
    private FTPService ftpService;

    private Logger logger = Logger.getLogger(FTPController.class);

    @RequestMapping(value="/pic/upload",method=RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadImage(String dir, String Filename, MultipartFile uploadFile)  {
        JSONObject jsonObject = new JSONObject();
        if(dir.equals("image")) {
            logger.info("image");
            logger.info(Filename);
            logger.info(uploadFile.getOriginalFilename());
            return ftpService.uploadImage(uploadFile);
            //multipart/form-data,接收一个MultiPartFile对象

        }
        return jsonObject;
    }
}
