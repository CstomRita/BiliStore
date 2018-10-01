package com.service.rest.controller;

import ResultType.ResponseResult;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.service.rest.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:21 2018/10/1
 * @ Description：ItemController
 * @ Modified By：
 * @Version: $
 */
@Controller
public class ItemController {

    private Logger logger = Logger.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/itemcat/all",produces = "application/json;charset=utf-8")
    @ResponseBody
//    "http://localhost:6676/rest/itemcat/all?callback=category.getDataService"
    public String getAllItemCat(@RequestParam("callback") String callback) {
        logger.info(callback);
        //id 0 所有
        String result = callback + "(" + JSONObject.toJSONString(itemService.getAllItemCat())+ ");";

       return result;
    }


}
