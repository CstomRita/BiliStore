/**
 * Copyright (C), 2017-2018
 * FileName: UserController
 * Author:   CstomRita
 * Date:     2018/9/13 23:03
 * Description: userController
 */
package com.manager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.manager.pojo.User;
import com.manager.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

/**
 * 〈userController〉
 *
 * @author CstomRita
 * @create 2018/9/13
 * @since 1.0.0
 */
@Controller
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping("/user/userid")
    @ResponseBody
    public User getUserById(@RequestBody String userid){
        logger.info("接收到userid"+userid);
//        User user = userService.getUserById(userid);
        return null;
    }

}