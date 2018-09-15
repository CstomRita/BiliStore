/**
 * Copyright (C), 2017-2018
 * FileName: User
 * Author:   CstomRita
 * Date:     2018/9/13 23:00
 * Description: UserPojo
 */
package com.manager.pojo;

/**
 * 〈UserPojo〉
 *
 * @author CstomRita
 * @create 2018/9/13
 * @since 1.0.0
 */
public class User {
    private int id;
    private String username;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String name) {
        this.username = name;
    }
}