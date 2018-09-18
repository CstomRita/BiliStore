package com.manager.service.impl;

import com.manager.mapper.TbItemCatMapper;
import com.manager.pojo.TbItem;
import com.manager.pojo.TbItemCat;
import com.manager.pojo.returntype.CatReturnType;
import com.manager.service.TbItemCatService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:54 2018/9/16
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Service
public class TbItemCatServiceImpl implements TbItemCatService {

   Logger logger = Logger.getLogger(TbItemCatServiceImpl.class);

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<CatReturnType> getTbItemCatByParentId(Integer id) {

        List<TbItemCat> list = itemCatMapper.getTbItemCatByParentId(id);
        logger.info("查询结果"+list.toString());

        List<CatReturnType> result = new ArrayList<>();
        Integer returnId = 1;
        for(TbItemCat tbItemCat : list) {
            CatReturnType catReturnType = new CatReturnType();
            catReturnType.setId(tbItemCat.getId());
            catReturnType.setState(tbItemCat.getIsParent()?"closed":"open");
            catReturnType.setText(tbItemCat.getName());
            result.add(catReturnType);
        }
        return result;
    }
}
