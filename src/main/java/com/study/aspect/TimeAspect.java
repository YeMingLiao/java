package com.study.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 切片
 * Created by gf on 2018/10/17.
 */
@Aspect
@Component
public class TimeAspect {

    public Object handleControllerMethod(ProceedingJoinPoint pdj) throws Throwable {
        System.out.println("aspect time start");

        Object[] args = pdj.getArgs();
        for (Object arg : args){
            System.out.println("arg is :"+arg);
        }

        long start = new Date().getTime();

        Object object = pdj.proceed();
        System.out.println("aspect time 耗时："+ (new Date().getTime() - start));

        System.out.println("aspect time end");
        return object;
    }
}
