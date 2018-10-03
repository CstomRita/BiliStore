package com.foreWeb.controller;

import com.foreWeb.service.WebContentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @Autowired
    private WebContentService webContentService;

    @RequestMapping("/index")
    public String showIndex(Model model) {
        logger.info("接收到请求首页的请求");
        String ad1 = webContentService.getContentList();
        logger.info(ad1);
        model.addAttribute("ad1", ad1);
        return "index";
    }

}
