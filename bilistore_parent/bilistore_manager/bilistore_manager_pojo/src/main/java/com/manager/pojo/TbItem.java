package com.manager.pojo;


import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午5:51 2018/9/15
 * @ Description：ItemDescription
 * @ Modified By：
 * @Version: v1.0$
 */
public class TbItem {
    private  Long id;
    private String title;
    private String sellPoint;
    private Long price;
    private Integer num;
    private String barcode;
    private String image;
    private Integer status;
    private Timestamp created;
    private Timestamp updated;
    private Long cid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
}
