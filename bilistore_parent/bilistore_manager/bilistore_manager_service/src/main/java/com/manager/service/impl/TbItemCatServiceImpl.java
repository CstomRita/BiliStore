package com.manager.service.impl;

import com.manager.mapper.TbItemCatMapper;
import com.manager.pojo.TbItemCat;
import ResultType.EasyUI_Tree_ReturnType;
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
    public List<EasyUI_Tree_ReturnType> getTbItemCatByParentId(Integer id) {

        List<TbItemCat> list = itemCatMapper.getTbItemCatByParentId(id);
        logger.info("查询结果"+list.toString());

        List<EasyUI_Tree_ReturnType> result = new ArrayList<>();
        Integer returnId = 1;
        for(TbItemCat tbItemCat : list) {
            EasyUI_Tree_ReturnType easyUITreeReturnType = new EasyUI_Tree_ReturnType();
            easyUITreeReturnType.setId(tbItemCat.getId());
            easyUITreeReturnType.setState(tbItemCat.getIsParent()?"closed":"open");
            easyUITreeReturnType.setText(tbItemCat.getName());
            result.add(easyUITreeReturnType);
        }
        return result;
    }
}
