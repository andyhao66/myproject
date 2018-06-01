package com.wechat.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hyf on 2018/2/6.
 */
@Controller
@RequestMapping(value = "/")
public class HelloController {

    @RequestMapping("/testhello")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "进入主页1");
        // return模板文件的名称，对应src/main/resources/templates/testWeb.html
        return "index";
    }

}
