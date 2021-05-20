package com.itcast.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lichunmiao
 * @date 2021/5/14
 */
@Service
public class BService {
    @Autowired
    private AService aService;

    public String sayHello() {
        return "hello";
    }
}
