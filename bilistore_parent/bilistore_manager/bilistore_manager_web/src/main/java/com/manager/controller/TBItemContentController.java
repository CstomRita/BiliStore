package com.manager.controller;

import ResultType.EasyUI_DataGrid_ReturnType;
import ResultType.EasyUI_Tree_ReturnType;
import ResultType.ResponseResult;
import com.manager.pojo.TbContent;
import com.manager.service.TbContentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午9:40 2018/10/2
 * @ Description：CMS内容管理系统
 * @ Modified By：
 * @Version: $
 */
@Controller
public class TBItemContentController {

    private Logger logger = Logger.getLogger(TBItemContentController.class);

    @Autowired
    private TbContentService tbContentService;

    @RequestMapping(value = "/content/category/list", method = RequestMethod.GET)
    @ResponseBody
    public List<EasyUI_Tree_ReturnType> getContentCategoryList(@RequestParam(value = "id",defaultValue = "0") Long parentId) {
        logger.info("接收到请求CMS分类列表的请求");
        return tbContentService.getContentCategoryList(parentId);
    }
    @RequestMapping(value = "/content/category/update",method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseResult updateContentCategoryList(Long id, String name) {
        logger.info("接收到请求Update分类列表的请求");
        return tbContentService.updateContentCategoryList(id,name);
    }
    @RequestMapping(value = "/content/category/create",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ResponseResult creatContentCategory(Long parentId, String name) {
        logger.info("接收到那请求CREAT分类的请求");
        return tbContentService.creatContentCategory(parentId,name);
    }
    @RequestMapping(value = "/content/category/delete",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ResponseResult deleteContentCategory(Long id) throws Exception {
        logger.info("接收到那请求delete分类的请求");
        return tbContentService.deleteContentCategory(id);
    }


    @RequestMapping(value = "/content/query/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUI_DataGrid_ReturnType getContentList(Long categoryId,Integer page, Integer rows) {
        logger.info("接收到显示内容的请求");
        return tbContentService.getContentList(categoryId,page,rows);
    }

    @RequestMapping(value = "/content/save",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ResponseResult addNewContent(TbContent content) {
        logger.info("收到新增内容的请求");
        return tbContentService.addNewContent(content);
    }
}
