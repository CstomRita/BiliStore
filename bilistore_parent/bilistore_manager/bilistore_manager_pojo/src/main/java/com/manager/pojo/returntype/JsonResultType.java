package com.manager.pojo.returntype;

import java.util.List;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:11 2018/9/16
 * @ Description：JsonResultType
 * 基本：
 * 通过@ResponseBOdy注解我们可以把一个对象返回JsonObject的格式
 * 如果是一个对象的List 返回的是JsonArray，每个元素都是一个对象的JsonObject
 * 如果还需要返回其他较为复杂的Json格式则需要自己定义了
 * 其实不需要返回一个JsonObject，手动添加复杂的Json格式，如果对象属性较多则会十分麻烦
 * 创建一个POJO，返回这个POJO类型的Json，如果JsonObject中需要JsonArray定义属性时变为List格式
 * @ Modified By：
 * @Version: v1.0$
 */
public class JsonResultType {

    //{"total":xx,"rows":[{},{},{}]}

    private Long total;

    private List<?> rows; //使用泛型任何类型

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
