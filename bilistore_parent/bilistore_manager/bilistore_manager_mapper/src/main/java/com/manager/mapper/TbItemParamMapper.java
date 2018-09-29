package com.manager.mapper;

import com.alibaba.fastjson.JSONObject;
import com.manager.pojo.TbItemParam;
import com.manager.pojo.TbItemParamItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//参数模板表
public interface TbItemParamMapper {

    //查询所有模板信息
    List<TbItemParam> getAllTbTtemParam();

    //删除一个模板
    Integer deleteTbItem(@Param("id") Long id);

    //根据类目调取模板
    TbItemParam getTbItemParamByCatId(@Param("item_cat_id") Long item_cat_id);

    //新增模板
    Integer saveItemParam(TbItemParam tbItemParam);
}
