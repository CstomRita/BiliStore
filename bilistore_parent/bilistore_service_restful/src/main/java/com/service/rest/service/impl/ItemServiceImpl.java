package com.service.rest.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.manager.mapper.TbItemCatMapper;
import com.manager.pojo.TbItemCat;
import com.service.rest.ReturnType.CastNode;
import com.service.rest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:41 2018/10/1
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public JSONObject getAllItemCat() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",getAllItemCat((new Long(0))));
        return jsonObject;
    }

    @Override
    public List<?> getAllItemCat(Long id) {
        List<TbItemCat> list = tbItemCatMapper.getTbItemCatByParentId(id);
        List resultList = new ArrayList<>();
//        注入到Node的List中
        int count = 0;
        for(TbItemCat itemCat : list) {
            //如果是父节点,需要添加catNode指明u n i
            if(itemCat.getIsParent()) {
                CastNode castNode = new CastNode();
                if(id == 0) {
                    castNode.setName("<a href='/products/"+itemCat.getId()+".html'>"+itemCat.getName()+"</a>");
                }else {
                    castNode.setName(itemCat.getName());
                }
                castNode.setUrl("/products/"+itemCat.getId()+".html");
                castNode.setItem(getAllItemCat(itemCat.getId()));
                resultList.add(castNode);
                count++;
                if(count > 13) break;
            }else { //不是父节点直接添加网页HTML
                resultList.add("/products/"+itemCat.getId()+".html|" + itemCat.getName());
            }
        }
        return resultList;
    }
}
