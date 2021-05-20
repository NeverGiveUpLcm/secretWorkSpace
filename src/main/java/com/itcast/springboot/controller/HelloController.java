package com.itcast.springboot.controller;

import com.itcast.service.HelloService;
import com.itcast.springboot.entity.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

/**
 * @author lichunmiao
 * @date 2020/12/7
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    //当person.name没有配置的时候取默认值"张三"
    @Value("${user.dir}")
    private String name;

    @Autowired
    private Man man;

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "hello springboot 2.0";
    }

    @GetMapping("/sql")
    @ResponseBody
    public String sql() {
        Long count = jdbcTemplate.queryForObject("select count(*) from boy ", Long.class);
        System.out.println(count);
        System.out.println(dataSource.getClass());
        return "success";
    }

    @GetMapping("/name")
    @ResponseBody
    public String getName(){
        return helloService.sayHello("zhangsan");
    }
}
