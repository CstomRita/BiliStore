package com.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.manager.pojo.TbItem;
import com.manager.pojo.returntype.CatReturnType;
import com.manager.pojo.returntype.JsonResultType;
import com.manager.service.TbItemCatService;
import com.manager.service.TbItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public JsonResultType getAllItem(Integer page, Integer rows) {
        //判断一下条件
        page = page == null ? 1 :page;
        rows = rows == null ? 30 : rows;
        logger.info("第"+page+"页,"+rows+"条数据");
       JsonResultType itemList = tbItemService.getAllItem(page,rows);
        return itemList;
    }

    //商品条目查询,会接收当前展开node的id
    @Autowired
    private TbItemCatService tbItemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<CatReturnType> getItemCat(Integer id) {
        id = id == null ? 0 :id;
        logger.info("接收到id:"+id);
        return tbItemCatService.getTbItemCatByParentId(id);
    }

    @RequestMapping(value="/item/save",method=RequestMethod.POST)
    @ResponseBody
    public JSONObject save(TbItem item,String desc) {
        logger.info(desc);
        return tbItemService.addNewItem(item);
    }


}
