package com.service.rest.controller;

import ResultType.ResponseResult;
import com.service.rest.service.ContentService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午7:24 2018/10/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Controller
public class ContentController {

    private Logger logger = Logger.getLogger(ContentController.class);

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/content/list/{contentCategoryId}")
    @ResponseBody
    public ResponseResult getContentList(@PathVariable("contentCategoryId") Long contentCategoryId) {
        logger.info("接收到ContentList的请求");
        try{
            return contentService.getContentList(contentCategoryId);
        }catch (Exception e) {
            //用ExceptionUtils.getStackTrace打印异常
            //失败时返回包装
            return ResponseResult.build(500,ExceptionUtils.getStackTrace(e));
        }
    }

}
