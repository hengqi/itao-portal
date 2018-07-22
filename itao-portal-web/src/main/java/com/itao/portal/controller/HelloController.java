package com.itao.portal.controller;

import com.itao.portal.service.HelloTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    HelloTestService helloTestService;

    @RequestMapping("/hello")
    @ResponseBody
    public String say(String name) {
        return helloTestService.sayHello(name);
    }
}
