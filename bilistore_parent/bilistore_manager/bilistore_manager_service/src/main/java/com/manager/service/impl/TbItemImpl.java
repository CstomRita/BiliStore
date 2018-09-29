package com.manager.service.impl;

import ResultType.EasyUI_DataGrid_ReturnType;
import ResultType.ResponseResult;
import Utils.NameIdUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mapper.TbItemDescMapper;
import com.manager.mapper.TbItemMapper;
import com.manager.mapper.TbItemParamItemMapper;
import com.manager.mapper.TbItemParamMapper;
import com.manager.pojo.TbItemDesc;
import com.manager.pojo.TbItem;
import com.manager.pojo.TbItemParam;
import com.manager.pojo.TbItemParamItem;
import com.manager.service.TbItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午6:06 2018/9/15
 * @ Description：TbItemService实现类
 * @ Modified By：
 * @Version: V1.0$
 */
@Service
public class TbItemImpl implements TbItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    private Logger logger = Logger.getLogger(TbItemImpl.class);

    @Override
    public EasyUI_DataGrid_ReturnType getAllItem(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<TbItem> list = itemMapper.getAllItem();
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        logger.info("pageSize:" + pageInfo.getPageSize());
        logger.info("size:" + pageInfo.getSize());
        logger.info("pageNum:" + pageInfo.getPageNum());
        logger.info("total:" + pageInfo.getTotal());
        //EasyUI中要求的Json格式：
        EasyUI_DataGrid_ReturnType jsonResult = new EasyUI_DataGrid_ReturnType();
        jsonResult.setRows(list);
        jsonResult.setTotal(pageInfo.getTotal());
        return jsonResult;
    }

    @Override
    public ResponseResult addNewItem(TbItem item, String desc,String itemParams) throws Exception {
        Long id = NameIdUtil.genItemId();
        item.setId(id);
        Timestamp now = new Timestamp(new Date().getTime());
        item.setCreated(now);
        item.setUpdated(now);
        item.setStatus(1);
        logger.info(id);
        itemMapper.addNewItem(item);

        ResponseResult responseResult = addOneDesc(id,desc);
        if(responseResult.getStatus() != 200) {
            logger.info("添加失败");
            //说明添加商品描述失败
            throw new Exception();
        }
        ResponseResult responseResult1 = addOneParam(id,itemParams);
        if(responseResult1.getStatus() != 200) {
            throw new Exception();
        }
        return ResponseResult.ok();
    }

    //添加商品描述
    private ResponseResult addOneDesc(Long id,String desc) {
        TbItemDesc itemDesc = new TbItemDesc();
        Timestamp now = new Timestamp(new Date().getTime());
        itemDesc.setCreated(now);
        itemDesc.setUpdated(null);
        itemDesc.setItemId(id);
        itemDesc.setItemDesc(desc);
        tbItemDescMapper.addOneDesc(itemDesc);
        return ResponseResult.ok();
    }
    //添加商品规格
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;
    private ResponseResult addOneParam(Long itemId,String paramData) {
        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setItemId(itemId);
        tbItemParamItem.setParamData(paramData);
        tbItemParamItem.setCreated(new Timestamp(new Date().getTime()));
        tbItemParamItem.setUpdated(new Timestamp(new Date().getTime()));
        tbItemParamItemMapper.insertTbItemParamItem(tbItemParamItem);
        return ResponseResult.ok();
    }

    //商品规格参数模板列表查询
    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Override
    public EasyUI_DataGrid_ReturnType getAllTbItemParam(Integer page, Integer rows) {
        //使用分页插件查询
        PageHelper.startPage(page,rows);
        List<TbItemParam> list = tbItemParamMapper.getAllTbTtemParam();

        //再封装成EasyUI中需要的格式
        EasyUI_DataGrid_ReturnType returnType = new EasyUI_DataGrid_ReturnType();
        returnType.setTotal(new PageInfo<>(list).getTotal());
        returnType.setRows(list);
        return returnType;
    }
    //商品规格参数模板列表删除
    @Override
    public ResponseResult deleteTbItemParam(Long id){
        tbItemParamMapper.deleteTbItem(id);
        return ResponseResult.ok();
    }
    //根据类别item_cat_id获取参数的模板
    public ResponseResult getItemCatParam(Long item_cat_id) {
        TbItemParam tbItemParam = tbItemParamMapper.getTbItemParamByCatId(item_cat_id);
        if(tbItemParam != null) {
            logger.info(tbItemParam.getParamData());
            return ResponseResult.ok(tbItemParam);
        }
        return ResponseResult.ok();
    }
    //新增模板
    @Override
    public ResponseResult saveItemParam(Long item_cat_id,String paramData){
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(item_cat_id);
        tbItemParam.setParamData(paramData);
        tbItemParam.setCreated(new Timestamp(new Date().getTime()));
        tbItemParam.setUpdated(new Timestamp(new Date().getTime()));
        tbItemParamMapper.saveItemParam(tbItemParam);
        return ResponseResult.ok();
    }

}
