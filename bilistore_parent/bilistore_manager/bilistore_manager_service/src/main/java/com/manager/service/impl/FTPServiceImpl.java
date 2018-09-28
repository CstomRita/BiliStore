package com.manager.service.impl;

import Utils.FTPUtil;
import Utils.NameIdUtil;
import com.alibaba.fastjson.JSONObject;
import com.manager.service.FTPService;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午5:35 2018/9/26
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Service
public class FTPServiceImpl implements FTPService {

    private Logger logger = Logger.getLogger(FTPServiceImpl.class);

    @Value("${FTP_host}")
    private String FTP_host;

    @Value("${FTP_port}")
    private String FTP_port;



    @Value("${FTP_userName}")
    private String FTP_userName;

    @Value("${FTP_passWord}")
    private String FTP_passWord;

    @Value("${FTP_basePath}")
    private String FTP_basePath;

    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;


    /**
     * 上传至FTP的业务逻辑：
     * 1 生成一个新的文件名称，防止文件重名,如何生成一个不重复的文件名：A UUID但是过长 B 时间+随机数
     * 2 上传图片到FTP
     * 返回格式
     * 成功时
     * {
     *     error:0,
     *     url:返回存储在FTP服务器的路径
     * }
     * 失败时
     * {
     *     error:1,
     *     message:错误信息
     * }
     */
    @Override
    public JSONObject uploadImage(MultipartFile multipartFile) {
        logger.info("port"+FTP_port+FTP_host);
        JSONObject jsonObject = new JSONObject();
        //在MultipartFile中取对象
        //MultipartFile.getXX
        String oldName = multipartFile.getOriginalFilename();
        logger.info("oldName"+oldName);
        String newName = NameIdUtil.genImageName()+oldName.substring(oldName.lastIndexOf('.'));//截取后缀名

        //上传到一个根据日期的路径
        try {
            String filePath = new DateTime().toString("/yyyy/MM/dd");
            boolean result = FTPUtil.uploadFile(FTP_host,Integer.parseInt(FTP_port),FTP_userName,FTP_passWord,FTP_basePath
                ,filePath,newName,multipartFile.getInputStream());
            if(result) {
                jsonObject.put("error",0);
                jsonObject.put("url",IMAGE_BASE_URL+filePath+newName);
                return jsonObject;
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        jsonObject.put("error",1);
        jsonObject.put("message","fail");
        return jsonObject;
    }
}
