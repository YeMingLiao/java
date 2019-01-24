package com.study.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 拦截：拦截器
 * Created by gf on 2018/10/17.
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
        System.out.println("preHandle");

        System.out.println(((HandlerMethod)handle).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handle).getMethod().getName());

        request.setAttribute("startTime",System.currentTimeMillis());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handle, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");

        Long start = (Long) request.getAttribute("startTime");

        System.out.println("time 耗时："+(System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handle, Exception e) throws Exception {
        System.out.println("afterCompletion");

        Long start = (Long) request.getAttribute("startTime");

        System.out.println("time 耗时："+(System.currentTimeMillis() - start));

        System.out.println("exception:"+e.getMessage());
    }
}
