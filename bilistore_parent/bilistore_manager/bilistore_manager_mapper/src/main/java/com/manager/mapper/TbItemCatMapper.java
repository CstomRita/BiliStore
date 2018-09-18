package com.manager.mapper;

import com.manager.pojo.TbItemCat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemCatMapper {

    List<TbItemCat> getTbItemCatByParentId(@Param("parentId") Integer parentId);
}
