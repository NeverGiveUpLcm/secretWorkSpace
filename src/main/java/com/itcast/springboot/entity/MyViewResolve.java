package com.itcast.springboot.entity;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author lichunmiao
 * @date 2021/5/14
 */
public class MyViewResolve implements ViewResolver {
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        return new MyView();
    }
}
