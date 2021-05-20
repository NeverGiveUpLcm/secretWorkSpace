package com.itcast.springboot.configuation;

import com.itcast.springboot.intercept.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lichunmiao
 * @date 2021/5/14
 */
@Configuration(proxyBeanMethods = false)
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //指定拦截器拦截的路径,/**表示拦截所有请求,包括静态资源
                .addPathPatterns("/**")
                //指定默认放心的资源路径,这里如果想统一放行静态资源的话,可以配置静态资源的统一访问路径,进行统一拦截
//                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**")
                .excludePathPatterns("/res/**")
                //设置拦截器的优先级
                .order(1);
    }
}
