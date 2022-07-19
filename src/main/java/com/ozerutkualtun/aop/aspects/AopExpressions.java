package com.ozerutkualtun.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.ozerutkualtun.aop.dao.*.*(..))")  // 1. wildcard class name, 2.wildcard method name için
    public void forDaoPackage() {}  // genel expression bu şekilde. Metodun içine bir şey yazılmaz. Çağrılmak istenilen yerde metod adı ile ulaşılabilir.

    @Pointcut("execution(* com.ozerutkualtun.aop.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.ozerutkualtun.aop.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoExceptGetterAndSetter() {}

}
