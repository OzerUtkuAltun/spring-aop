package com.ozerutkualtun.aop.aspects;

import com.ozerutkualtun.aop.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
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


    @Before("com.ozerutkualtun.aop.aspects.AopExpressions.forDaoExceptGetterAndSetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n>>>>>>>>>>>>>>>>>>>EXECUTING @Before advice - Demo Logging Aspect (Order 1)");
    }

    @AfterReturning(
            pointcut = "com.ozerutkualtun.aop.aspects.AopExpressions.forDaoExceptGetterAndSetter()",
            returning = "result")   // afterReturning metod başarıyla çalıştıktan sonra tetiklenir.
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) { // result = returningteki value

        System.out.println("\n>>>>>>>>EXECUTING @AfteReturning on method: " + joinPoint.getSignature().toShortString());
        System.out.println("\n>>>>>>>>RESULT is: " + result);


    }

}
