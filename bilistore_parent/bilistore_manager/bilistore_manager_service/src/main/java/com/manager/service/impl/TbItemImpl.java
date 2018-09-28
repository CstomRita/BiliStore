package com.manager.service.impl;

import Utils.NameIdUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mapper.TbItemMapper;
import com.manager.pojo.returntype.JsonResultType;
import com.manager.pojo.TbItem;
import com.manager.service.TbItemService;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
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

    private Logger logger = Logger.getLogger(TbItemImpl.class);

    @Override
    public JsonResultType getAllItem(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<TbItem> list = itemMapper.getAllItem();
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        logger.info("pageSize:"+pageInfo.getPageSize());
        logger.info("size:"+pageInfo.getSize());
        logger.info("pageNum:"+pageInfo.getPageNum());
        logger.info("total:"+pageInfo.getTotal());
        //EasyUI中要求的Json格式：
       JsonResultType jsonResult = new JsonResultType();
       jsonResult.setRows(list);
       jsonResult.setTotal(pageInfo.getTotal());
        return jsonResult;
    }

    @Override
    public JSONObject addNewItem(TbItem item) {
        JSONObject result = new JSONObject();
        item.setId(NameIdUtil.genItemId());
        item.setCreated(new Timestamp(new Date().getTime()));
        item.setUpdated(new Timestamp(new Date().getTime()));
        item.setStatus(1);
        logger.info(item.getUpdated());
        itemMapper.addNewItem(item);
        result.put("status",200);
        return result;
    }

}
