package com.itcast.springboot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author lichunmiao
 * @date 2021/5/17
 */
@Slf4j
@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("项目启动完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("项目已经关闭");
    }
}
