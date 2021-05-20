package com.itcast.springboot.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lichunmiao
 * @date 2021/5/14
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        log.info("preHandle拦截的请求路径是{}", requestURI);

//        //登录检查逻辑
//        HttpSession session = request.getSession();
//
//        Object loginUser = session.getAttribute("loginUser");
//
//        if (loginUser != null) {
//            //放行
//            return true;
//        }
//        //拦截住。未登录。跳转到登录页
//        request.setAttribute("msg", "请先登录");
////        re.sendRedirect("/");
//        request.getRequestDispatcher("/").forward(request, response);
        return true;
    }

    /**
     * 目标方法执行完成之后执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.info("postHandle执行{}", modelAndView);
    }

    /**
     * 页面渲染完成之后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("afterCompletion执行异常{}", ex);
    }
}
