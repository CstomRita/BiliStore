package com.manager.mapper;

import com.manager.pojo.TbItemParamItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品规格参数模板表
 */
public interface TbItemParamItemMapper {
    //添加商品规格
    Integer insertTbItemParamItem(TbItemParamItem tbItemParamItem);
}
