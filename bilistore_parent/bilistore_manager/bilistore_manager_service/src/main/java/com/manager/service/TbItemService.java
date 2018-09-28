package com.manager.service;

import com.alibaba.fastjson.JSONObject;
import com.manager.pojo.TbItem;
import com.manager.pojo.returntype.JsonResultType;

public interface TbItemService {

    JsonResultType getAllItem(Integer page, Integer rows);

//    getAllTbItem();
    JSONObject addNewItem(TbItem item);
}
