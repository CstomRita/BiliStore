package com.service.rest.service.impl;

import ResultType.ResponseResult;
import com.manager.mapper.TbItemContentMapper;
import com.manager.pojo.TbContent;
import com.service.rest.service.ContentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午7:09 2018/10/2
 * @ Description：内容实现类
 * @ Modified By：
 * @Version: $
 */

@Service
public class ContentServiceImpl implements ContentService {

    private Logger logger = Logger.getLogger(ContentServiceImpl.class);

    @Autowired
    private TbItemContentMapper tbItemContentMapper;

    @Override
    public ResponseResult getContentList(Long contentCategoryId) {
        List<TbContent> list = tbItemContentMapper.getContentListByCategoryId(contentCategoryId);
        return ResponseResult.ok(list);
    }
}
