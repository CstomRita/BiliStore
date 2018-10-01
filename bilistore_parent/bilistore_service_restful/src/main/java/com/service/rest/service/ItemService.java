package com.service.rest.service;

import com.alibaba.fastjson.JSONObject;
import com.manager.pojo.TbItemCat;

import java.util.List;

public interface ItemService {

    JSONObject getAllItemCat();

    List<?> getAllItemCat(Long id);
}
