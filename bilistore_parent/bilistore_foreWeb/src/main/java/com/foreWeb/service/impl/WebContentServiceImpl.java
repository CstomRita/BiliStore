package com.foreWeb.service.impl;


import Utils.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.foreWeb.service.WebContentService;
import org.apache.log4j.Logger;
import org.noggit.JSONUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午9:36 2018/10/3
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Service
public class WebContentServiceImpl implements WebContentService {

    private  Logger logger = Logger.getLogger(WebContentService.class);

    public  String getContentList() {
        String url = "http://localhost:6676/rest/content/list/89";
        String result = HttpClientUtil.doGet(url);
        //把字符串转换成TaotaoResult
        //取内容列表
        JSONObject jsonObject = JSON.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        JSONArray objects = new JSONArray();
        //创建一个jsp页码要求的pojo列表
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            JSONObject map = new JSONObject();
            map.put("src", object.get("pic"));
            map.put("height", 240);
            map.put("width", 670);
            map.put("srcB", object.get("pic"));
            map.put("widthB", 550);
            map.put("heightB", 240);
            map.put("href", object.get("url"));
            map.put("alt", object.get("subTitle"));
            objects.add(map);
        }
        return objects.toJSONString();
    }
}
