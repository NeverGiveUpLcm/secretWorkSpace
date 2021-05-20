package com.itcast.springboot.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lichunmiao
 * @date 2021/5/17
 */

/**
 * @Order注解指定我自定义的异常解析的执行位置,现在是放在第一个执行
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            response.sendError(511, "跳转我喜欢的错误页面");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
