package com.itcast.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author lichunmiao
 * @date 2021/5/17
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "请求出现了异常")
public class MyException extends RuntimeException {

    private String message;

    public MyException(String message) {
        super(message);
    }
}
