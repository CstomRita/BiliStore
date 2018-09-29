package com.manager.controller;

import ResultType.EasyUI_DataGrid_ReturnType;
import ResultType.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import com.manager.pojo.TbItem;
import ResultType.EasyUI_Tree_ReturnType;
import com.manager.service.TbItemCatService;
import com.manager.service.TbItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午6:09 2018/9/15
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Controller
@RequestMapping
public class TbItemController {

    @Autowired
    private TbItemService tbItemService;

    private Logger logger = Logger.getLogger(TbItemController.class);

    //商品列表查询
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUI_DataGrid_ReturnType getAllItem(Integer page, Integer rows) {
        //判断一下条件
        page = page == null ? 1 :page;
        rows = rows == null ? 30 : rows;
        logger.info("第"+page+"页,"+rows+"条数据");
       EasyUI_DataGrid_ReturnType itemList = tbItemService.getAllItem(page,rows);
        return itemList;
    }

    //商品条目查询,会接收当前展开node的id
    @Autowired
    private TbItemCatService tbItemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUI_Tree_ReturnType> getItemCat(Integer id) {
        id = id == null ? 0 :id;
        logger.info("接收到id:"+id);
        return tbItemCatService.getTbItemCatByParentId(id);
    }

    //新增商品保存
    @RequestMapping(value="/item/save",method=RequestMethod.POST)
    @ResponseBody
    public ResponseResult save(TbItem item, String desc,String ItemParams) throws Exception {
        logger.info(desc);
        return tbItemService.addNewItem(item,desc,ItemParams);
    }

    //商品规格参数list查询,分页插件查询
    @RequestMapping(value="/item/param/list",method=RequestMethod.GET)
    @ResponseBody
    public EasyUI_DataGrid_ReturnType getAllParamList(Integer page, Integer rows){
        logger.info("第"+page+"页,"+rows+"条数据");
        return tbItemService.getAllTbItemParam(page,rows);
    }
    //商品规格参数删除
    @RequestMapping(value="/item/param/delete",method=RequestMethod.POST)
    @ResponseBody
    public ResponseResult deleteParam(@RequestParam("ids") Long id) {
        logger.info("删除参数模板id"+id);
       return tbItemService.deleteTbItemParam(id);
    }
    //获取商品参数模板
    @RequestMapping(value="/item/param/query/itemcatid/{id}",method=RequestMethod.GET)
    @ResponseBody
    public ResponseResult getTbItemParam(@PathVariable("id") Long item_cat_id){
        logger.info("获取模板类别"+item_cat_id);
        return tbItemService.getItemCatParam(item_cat_id);
    }
    //新增商品参数模板
    @RequestMapping(value="/item/param/save/{id}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult saveTbItemParam(@PathVariable("id") Long item_cat_id,String paramData) {
        return tbItemService.saveItemParam(item_cat_id,paramData);
    }

}
