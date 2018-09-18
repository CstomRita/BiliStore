package com.manager.service;

import com.manager.pojo.returntype.JsonResultType;

public interface TbItemService {

    JsonResultType getAllItem(Integer page, Integer rows);

//    getAllTbItem();
}
