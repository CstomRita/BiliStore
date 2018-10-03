package com.manager.service;

import ResultType.EasyUI_DataGrid_ReturnType;
import ResultType.EasyUI_Tree_ReturnType;
import ResultType.ResponseResult;
import com.manager.pojo.TbContent;

import java.security.acl.LastOwnerException;
import java.util.List;

public interface TbContentService {

    //获取内容分类
    List<EasyUI_Tree_ReturnType> getContentCategoryList(Long parentId);
    //Update
    ResponseResult updateContentCategoryList(Long id, String name);
    //creat
    ResponseResult creatContentCategory(Long parentId, String name);
    //delete
    ResponseResult deleteContentCategory(Long id) throws Exception;


    //内容管理
    EasyUI_DataGrid_ReturnType getContentList(Long categoryId, Integer page, Integer rows);
    ResponseResult addNewContent(TbContent content);
}
