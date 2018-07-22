package com.itao.portal.service;

import com.itao.rests.api.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloTestServiceImpl implements HelloTestService {

    @Autowired
    private HelloService helloService;

    @Override
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }
}
