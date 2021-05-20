package com.itcast.springboot.controller;

import com.itcast.springboot.entity.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lichunmiao
 * @date 2021/5/12
 */
@Controller
public class PojoTestController {

    @GetMapping("/people")
    @ResponseBody
    public People save(People people) {
        return people;
    }
}
