package com.itcast.springboot.controller;

import com.itcast.springboot.entity.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lichunmiao
 * @date 2021/5/14
 */
@Controller
public class ViewResolveController {

    @GetMapping("/hello1")
    public String hello(People people, Model model) {
        model.addAttribute("people", people);
        return "redirect:/success1";
    }

    @GetMapping("/success1")
    public String success() {
        return "success1";
    }

    @GetMapping("/forward")
    public String forward() {
        return "forward:/success";
    }


}
