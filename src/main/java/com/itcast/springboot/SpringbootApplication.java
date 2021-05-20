package com.itcast.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * 主程序类
 *
 * @SpringBootApplication: 这是一个SpringBoot应用
 */
//@ComponentScan(basePackages = {"com.itcast.springboot"})
@SpringBootApplication(scanBasePackages = "com.itcast.springboot")
/**
 * 通过在配置类上添加@ImportResource注解来引入我们的配置文件
 */
//@ImportResource("classpath:spring.xml")

/**
 * @ServletComponentScan就是用来扫描Servlet的组件Servlet、Filter和Listener的
 */
//@ServletComponentScan(basePackages = {"com.itcast.springboot"})
@MapperScan({"com.itcast.springboot"})
public class SpringbootApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(SpringbootApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        //可以获得系统环境
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
        //获得系统环境的属性
        Map<String, Object> systemProperties = environment.getSystemProperties();
        System.out.println(systemEnvironment);
        System.out.println("===================");
        System.out.println(systemProperties);
    }
}
