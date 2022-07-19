package com.ozerutkualtun.aop.aspects;

import com.ozerutkualtun.aop.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

    // advice'lara order verebilmek için farklı aspectlere taşımak lazım. Ardından @order ile sıra verilebilir.

    @Before("com.ozerutkualtun.aop.aspects.AopExpressions.forDaoExceptGetterAndSetter()")
    public void performAPIAnalytics(JoinPoint joinPoint) {

        System.out.println(">>>>>>>>>>>>>>>>>>>EXECUTING API ANALYTICS on @Before advice. Order 3");

        // display the method signature

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method Signature: " + methodSignature);

        // display method parameters

        System.out.println("\nMethod Parameters:");
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {

            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account mail: " + account.getEmail());
            } else {
                System.out.println("VIP: " + arg);
            }
        }
    }
}
