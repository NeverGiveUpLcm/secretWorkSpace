package com.itcast.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lichunmiao
 * @date 2021/5/11
 */
@Controller
public class RequestAttributeController {

    @RequestMapping("/goto")
    public String gotoPage(HttpServletRequest request) {
        request.setAttribute("msg", "成功了");
        request.setAttribute("code", 200);
        return "forward:/success";
    }

    @RequestMapping("/success")
    @ResponseBody
    public Map<String, Object> success(@RequestAttribute(value = "msg") String message,
                                       @RequestAttribute(value = "code") Integer code,
                                       HttpServletRequest httpServletRequest) {
        HashMap<String, Object> resultMap = new HashMap<>(2);

        resultMap.put("msg", message);
        resultMap.put("msg1", httpServletRequest.getAttribute("msg"));
        resultMap.put("code", code);
        resultMap.put("code1", httpServletRequest.getAttribute("code"));
        return resultMap;
    }
}
