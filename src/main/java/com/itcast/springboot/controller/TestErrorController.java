package com.itcast.springboot.controller;

import com.itcast.springboot.exception.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lichunmiao
 * @date 2021/5/15
 */
@RestController
public class TestErrorController {

    @GetMapping("/test")
    public String test(@RequestParam("name") String name) {
        throw new MyException("抛出自定义的异常信息");
    }

//    @ExceptionHandler({ArithmeticException.class})
//    public String handleSelfException(Exception e){
//        System.out.println(e);
//        return "通过本类的异常处理器进行了处理";
//    }

}
