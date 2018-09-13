/**
 * Copyright (C), 2017-2018
 * FileName: UserServiceImpl
 * Author:   CstomRita
 * Date:     2018/9/13 23:08
 * Description: userServiceImpl
 */
package com.manager.service.impl;


import com.manager.mapper.UserMapper;
import com.manager.pojo.User;
import com.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈userServiceImpl〉
 *
 * @author CstomRita
 * @create 2018/9/13
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(int id) {

        return userMapper.getUserById(1);
    }
}