package com.ozerutkualtun.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class CloudLogAspect {


    @Before("com.ozerutkualtun.aop.aspects.AopExpressions.forDaoExceptGetterAndSetter()")
    public void logToCloudAsync() {

        System.out.println("\n>>>>>>>>>>>>>>>>>>>EXECUTING (Logging entries to cloud in async fashion. Order 2)");
    }
}
