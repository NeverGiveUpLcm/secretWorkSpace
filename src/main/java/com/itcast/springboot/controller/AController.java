package com.itcast.springboot.controller;

import com.itcast.springboot.service.AService;
import com.itcast.springboot.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lichunmiao
 * @date 2021/5/14
 */
@RestController
public class AController {
    @Autowired
    private AService aService;

    @Autowired
    private BService bService;

    @GetMapping("/A")
    public String A() {
        return aService.sayHello();
    }
}
