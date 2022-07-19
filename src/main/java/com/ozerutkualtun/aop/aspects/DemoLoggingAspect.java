package com.ozerutkualtun.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    /*
     pointcut expression language:

     execution(modifiers-pattern? return-type-pattern? declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)    ? = optional

    "EXAMPLES: "

    1- addAccount method in only AccountDao class:

    @Before("execution(public void com.ozerutkualtun.aop.dao.AccountDao.addAccount())")


    2- any addAccount method in any class:

    @Before("execution(public void addAccount())")


    3- methods with starting add in any class (using wildcards *)

    @Before(execution("public void add*()"))


    4- methods with starting processCreditCard in any class (using wildcards *)

    @Before(execution("public VerificationResult processCreditCard*()"))


    5- wildcard can be used on return type

     @Before(execution("public * processCreditCard*()"))
     @Before(execution("* processCreditCard*()")) -> modifier zaten optional


     ---------------------------------------------------

     PARAMETER PATTERN WILDCARDS

     ()  -> matches a method with no args.
     (*)  -> matches a method with one arg. of any type
     (..)  -> matches a method with 0 or more args of any type



    NOTE: match any method in our dao package:

    @Before("execution(* com.ozerutkualtun.aop.dao.*.*(..))")


    ----------------------------

    @PointCut expressions: bir pointcut expressionu birden fazla aspectte kullanmak istediğimizde tek tek
    copy paste yapmak iyi ve doğru bir çözüm değil. Bunun için @Pointcut tanımlayabilir ve tanımladığımız
    pointcutları logic işlemlerde de kullanabiliriz.

   */

    @Pointcut("execution(* com.ozerutkualtun.aop.dao.*.*(..))")  // 1. wildcard class name, 2.wildcard method name için
    public void forDaoPackage() {}  // genel expression bu şekilde. Metodun içine bir şey yazılmaz. Çağrılmak istenilen yerde metod adı ile ulaşılabilir.



    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n>>>>>>>>>>>>>>>>>>>EXECUTING @Before advice");
    }


    @Before("forDaoPackage()")
    public void performAPIAnalytics() {

        System.out.println(">>>>>>>>>>>>>>>>>>>EXECUTING API ANALYTICS on @Before advice");
    }
}
