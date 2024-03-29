package com.ozerutkualtun.aop;

import com.ozerutkualtun.aop.config.DemoConfig;
import com.ozerutkualtun.aop.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturningDemoApp {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        try {
            System.out.println(accountDao.findAccounts(false));
        } catch (Exception e) {
            e.printStackTrace();
        }

        context.close();
    }
}
