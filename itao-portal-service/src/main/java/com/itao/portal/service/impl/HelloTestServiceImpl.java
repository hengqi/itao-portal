package com.itao.portal.service.impl;

import com.itao.integration.shard.HelloServie;
import com.itao.portal.service.HelloTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloTestServiceImpl implements HelloTestService {

    @Autowired
    private HelloServie helloServie;

    @Override
    public String sayHello(String name) {
        return helloServie.sayHello(name);
    }
}
