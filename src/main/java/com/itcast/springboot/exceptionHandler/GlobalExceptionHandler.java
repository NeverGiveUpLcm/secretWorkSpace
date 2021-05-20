package com.itcast.springboot.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author lichunmiao
 * @date 2021/5/17
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ArithmeticException.class})
    public String handleArithmeticException(Exception e) {
        log.info("捕获的异常为:{}", e);
        return "success1";
    }
}
