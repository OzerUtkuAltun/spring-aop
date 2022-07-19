package com.ozerutkualtun.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

    // advice'lara order verebilmek için farklı aspectlere taşımak lazım. Ardından @order ile sıra verilebilir.

    @Before("com.ozerutkualtun.aop.aspects.AopExpressions.forDaoExceptGetterAndSetter()")
    public void performAPIAnalytics() {

        System.out.println(">>>>>>>>>>>>>>>>>>>EXECUTING API ANALYTICS on @Before advice. Order 3");
    }

}
