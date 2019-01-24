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

        return null;
    }
}
