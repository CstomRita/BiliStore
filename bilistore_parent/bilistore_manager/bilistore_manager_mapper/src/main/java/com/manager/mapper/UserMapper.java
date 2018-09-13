/**
 * Copyright (C), 2017-2018
 * FileName: UserMapper
 * Author:   CstomRita
 * Date:     2018/9/13 23:01
 * Description: UserMapper
 */
package com.manager.mapper;

import com.manager.pojo.User;

/**
 * 〈UserMapper〉
 *
 * @author CstomRita
 * @create 2018/9/13
 * @since 1.0.0
 */
public interface UserMapper {
    User getUserById(int id);
}