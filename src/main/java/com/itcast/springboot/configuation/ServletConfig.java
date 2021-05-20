package com.itcast.springboot.configuation;

import com.itcast.springboot.servlet.MyFilter;
import com.itcast.springboot.servlet.MyListener;
import com.itcast.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author lichunmiao
 * @date 2021/5/17
 */

/**
 * proxyBeanMethods = true保证依赖的组件始终是单实例的,如果是false的话就不会从容器中找,而是每次用到的时候就创建一个
 */
@Configuration(proxyBeanMethods = true)
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<MyServlet> myServlet() {
        MyServlet myServlet = new MyServlet();
        ServletRegistrationBean<MyServlet> myServletServletRegistrationBean = new ServletRegistrationBean<>();
        myServletServletRegistrationBean.setServlet(myServlet);
        myServletServletRegistrationBean.setUrlMappings(Arrays.asList("/my", "/you", "/he"));
        return myServletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilter() {
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        myFilterFilterRegistrationBean.setFilter(myFilter);
        //可以自定义过滤器拦截的路径
        myFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        //这样过滤器拦截到的请求就是myServlet拦截到的请求
//        myFilterFilterRegistrationBean.setServletNames(Collections.singleton("myServlet"));
        return myFilterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyListener> myListener() {
        MyListener myListener = new MyListener();
        return new ServletListenerRegistrationBean<>(myListener);
    }
}
