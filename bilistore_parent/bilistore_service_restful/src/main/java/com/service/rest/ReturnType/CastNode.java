package com.service.rest.ReturnType;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午2:59 2018/10/1
 * @ Description：分类节点
 * @ Modified By：
 * @Version: $
 */
public class CastNode {
    /**
     * u n i
     * url String
     * name String
     * item list
     */
    @JSONField(name="n")
    private String name;


    @JSONField(name = "u")
    private String url;

    @JSONField(name = "i")
    private List<?> item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<?> getItem() {
        return item;
    }

    public void setItem(List<?> item) {
        this.item = item;
    }
}
