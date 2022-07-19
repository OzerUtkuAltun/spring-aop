package com.ozerutkualtun.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    @Before("execution(public void addAccount())") // içerideki expression = pointcut
    public void beforeAddAccountAdvice() {

        System.out.println("\n>>>>>>>>>>>>>>>>>>>EXECUTING @Before advice");
    }
}
