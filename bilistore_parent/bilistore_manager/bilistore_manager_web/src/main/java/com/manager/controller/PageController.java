package com.manager.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午1:46 2018/9/15
 * @ Description：不传参仅仅用作页面跳转
 * @ Modified By：
 * @Version: $
 */
@Controller
public class PageController {
    Logger logger = Logger.getLogger(PageController.class);

    /**页面跳转**/
    @RequestMapping("/{page}")
    public String jumpToPage(@PathVariable String page) {
        logger.info("JumpToPage:"+page);
        return page;
    }
    //return的其实是SpringMVC中视图解析器配置的前缀+page+后缀页面
}
