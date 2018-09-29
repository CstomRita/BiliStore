package com.manager.service;

import ResultType.EasyUI_DataGrid_ReturnType;
import ResultType.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import com.manager.pojo.TbItem;

public interface TbItemService {

    EasyUI_DataGrid_ReturnType getAllItem(Integer page, Integer rows);

//    getAllTbItem();
    ResponseResult addNewItem(TbItem item, String desc,String ItemParams) throws Exception;

    //商品规格参数模板列表查询
    EasyUI_DataGrid_ReturnType getAllTbItemParam(Integer page, Integer rows);
    //商品规格参数模板删除
    ResponseResult deleteTbItemParam(Long id);
    //根据类别item_cat_id获取参数的模板
    ResponseResult getItemCatParam(Long item_cat_id);
    //新增模板
    ResponseResult saveItemParam(Long item_cat_id,String paramData);
}
