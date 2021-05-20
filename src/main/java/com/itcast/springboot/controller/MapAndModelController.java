package com.itcast.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lichunmiao
 * @date 2021/5/12
 */
@Controller
public class MapAndModelController {

    @GetMapping("/params")
    public String testParams(Map<String, Object> map,
                             Model model,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        map.put("hello", "666");
        model.addAttribute("world", "8888");
        request.setAttribute("message", "hello world");
        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);
        return "forward:/success";
    }

    @GetMapping("/success")
    @ResponseBody
    public Map<String, Object> success(@RequestAttribute("message") String message,
                                       HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>(3);
        resultMap.put("message", message);
        resultMap.put("hello", request.getAttribute("hello"));
        resultMap.put("world", request.getAttribute("world"));
        return resultMap;
    }


}
