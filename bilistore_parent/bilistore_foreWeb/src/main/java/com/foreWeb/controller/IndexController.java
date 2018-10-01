package com.foreWeb.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:28 2018/9/30
 * @ Description：首页展示
 * @ Modified By：
 * @Version: $
 */
@Controller
public class IndexController {

    private Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String showIndex() {
        logger.info("接收到请求首页的请求");
        return "index";
    }

}
