package com.manager.service;

import com.manager.pojo.returntype.CatReturnType;

import java.util.List;

public interface TbItemCatService {

    List<CatReturnType> getTbItemCatByParentId(Integer id);
}
