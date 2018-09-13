/**
 * Copyright (C), 2017-2018
 * FileName: UserService
 * Author:   CstomRita
 * Date:     2018/9/13 23:02
 * Description: userService
 */
package com.manager.service;

import com.manager.pojo.User;

/**
 * 〈userService〉
 *
 * @author CstomRita
 * @create 2018/9/13
 * @since 1.0.0
 */
public interface UserService {
    User getUserById(int id);
}