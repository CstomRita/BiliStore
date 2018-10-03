package com.manager.service.impl;

import ResultType.EasyUI_DataGrid_ReturnType;
import ResultType.EasyUI_Tree_ReturnType;
import ResultType.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mapper.TbItemContentMapper;
import com.manager.pojo.TbContent;
import com.manager.pojo.TbContentCategory;
import com.manager.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午9:59 2018/10/2
 * @ Description：CMS业务处理
 * @ Modified By：
 * @Version: $
 */
@Service
public class TbContentServiceImpl  implements TbContentService {

    @Autowired
    private TbItemContentMapper tbItemContentMapper;

    @Override
    public List<EasyUI_Tree_ReturnType> getContentCategoryList(Long parentId) {

        List<TbContentCategory> list = tbItemContentMapper.getContentCategoryList(parentId);
        List<EasyUI_Tree_ReturnType> result = new ArrayList<>();
        for(TbContentCategory tbContentCategory : list) {
            EasyUI_Tree_ReturnType easyUI_tree_returnType = new EasyUI_Tree_ReturnType();
            easyUI_tree_returnType.setId(tbContentCategory.getId());
            easyUI_tree_returnType.setText(tbContentCategory.getName());
            if(tbContentCategory.getIsParent()) {
                easyUI_tree_returnType.setState("closed");
            }else {
                easyUI_tree_returnType.setState("open");
            }
            result.add(easyUI_tree_returnType);
        }
        return result;
    }

    @Override
    public ResponseResult updateContentCategoryList(Long id, String name) {
        TbContentCategory tbContentCategory = tbItemContentMapper.getContentCategoryById(id);
        tbContentCategory.setName(name);
        tbItemContentMapper.updateContentCategoryList(tbContentCategory);
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult creatContentCategory(Long parentId, String name) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setParentId(parentId);
        tbContentCategory.setName(name);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setUpdated(new Timestamp(new Date().getTime()));
        tbContentCategory.setCreated(new Timestamp(new Date().getTime()));
        tbContentCategory.setSortOrder(1);
        //'状态。可选值:1(正常),2(删除)'
        tbContentCategory.setStatus(1);
        tbItemContentMapper.creatContentCategory(tbContentCategory);

        TbContentCategory parent = tbItemContentMapper.getContentCategoryById(parentId);
        if( ! parent.getIsParent()) {
            parent.setIsParent(true);
            tbItemContentMapper.updateContentCategoryList(parent);
        }
        return ResponseResult.ok(tbContentCategory);
    }

    @Override
    public ResponseResult deleteContentCategory(Long id) throws Exception {
        Long parentId = tbItemContentMapper.getContentCategoryById(id).getParentId();
        ResponseResult result = deleteContentCategoryById(id);
        if(result.getStatus() != 200) throw new Exception();
        List<TbContentCategory> list = tbItemContentMapper.getContentCategoryList(parentId);
        if(list.isEmpty()) {
            TbContentCategory parent = tbItemContentMapper.getContentCategoryById(parentId);
            parent.setIsParent(false);
            tbItemContentMapper.updateContentCategoryList(parent);
        }
        return ResponseResult.ok();
    }
    private ResponseResult deleteContentCategoryById(Long id) throws Exception {
        tbItemContentMapper.deleteContentCategoryById(id);
        List<TbContentCategory> list = tbItemContentMapper.getContentCategoryList(id);
        for(TbContentCategory tbContentCategory : list) {
            ResponseResult result = deleteContentCategoryById(tbContentCategory.getId());
            if(result.getStatus() != 200) throw new Exception();
        }
        return ResponseResult.ok();
    }

    /**
     * 内容管理
     */

    @Override
    public EasyUI_DataGrid_ReturnType getContentList(Long categoryId, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<TbContent> list = tbItemContentMapper.getContentListByCategoryId(categoryId);
        PageInfo<TbContent> pageInfo = new PageInfo<>(list);
        EasyUI_DataGrid_ReturnType returnType = new EasyUI_DataGrid_ReturnType();
        returnType.setRows(list);
        returnType.setTotal(pageInfo.getTotal());
        return returnType;
    }

    public ResponseResult addNewContent(TbContent content) {
        content.setCreated(new Timestamp(new Date().getTime()));
        content.setUpdated(new Timestamp(new Date().getTime()));
        tbItemContentMapper.addNewContent(content);
        return ResponseResult.ok();
    }

}
