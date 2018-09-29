package com.manager.pojo;


import java.sql.Timestamp;

/**
 * Database Table Remarks:
 *   商品描述表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tb_item_desc
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class TbItemDesc {
    /**
     * Database Column Remarks:
     *   商品ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item_desc.item_id
     *
     * @mbggenerated
     */
    private Long itemId;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item_desc.created
     *
     * @mbggenerated
     */
    private Timestamp created;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item_desc.updated
     *
     * @mbggenerated
     */
    private Timestamp updated;

    /**
     * Database Column Remarks:
     *   商品描述
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item_desc.item_desc
     *
     * @mbggenerated
     */
    private String itemDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item_desc.item_id
     *
     * @return the value of tb_item_desc.item_id
     *
     * @mbggenerated
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item_desc.item_id
     *
     * @param itemId the value for tb_item_desc.item_id
     *
     * @mbggenerated
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item_desc.created
     *
     * @return the value of tb_item_desc.created
     *
     * @mbggenerated
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item_desc.created
     *
     * @param created the value for tb_item_desc.created
     *
     * @mbggenerated
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item_desc.updated
     *
     * @return the value of tb_item_desc.updated
     *
     * @mbggenerated
     */
    public Timestamp getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item_desc.updated
     *
     * @param updated the value for tb_item_desc.updated
     *
     * @mbggenerated
     */
    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item_desc.item_desc
     *
     * @return the value of tb_item_desc.item_desc
     *
     * @mbggenerated
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item_desc.item_desc
     *
     * @param itemDesc the value for tb_item_desc.item_desc
     *
     * @mbggenerated
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }
}