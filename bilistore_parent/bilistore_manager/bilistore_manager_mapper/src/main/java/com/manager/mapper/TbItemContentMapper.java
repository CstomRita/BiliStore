package com.manager.mapper;

import com.manager.pojo.TbContent;
import com.manager.pojo.TbContentCategory;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface TbItemContentMapper {


    TbContentCategory getContentCategoryById(Long id);

    List<TbContentCategory> getContentCategoryList(@Param("parentId") Long parentId);

    Integer updateContentCategoryList(TbContentCategory tbContentCategory);

    Integer creatContentCategory(TbContentCategory tbContentCategory);

    Integer deleteContentCategoryById(Long id);


    List<TbContent> getContentListByCategoryId(Long categoryId);
    Integer addNewContent(TbContent content);
}
