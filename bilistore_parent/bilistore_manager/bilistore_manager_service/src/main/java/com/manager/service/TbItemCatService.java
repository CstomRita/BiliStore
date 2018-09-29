package com.manager.service;

import ResultType.EasyUI_Tree_ReturnType;

import java.util.List;

public interface TbItemCatService {

    List<EasyUI_Tree_ReturnType> getTbItemCatByParentId(Integer id);
}
