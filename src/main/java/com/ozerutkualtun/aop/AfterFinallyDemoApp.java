package com.ozerutkualtun.aop;

import com.ozerutkualtun.aop.config.DemoConfig;
import com.ozerutkualtun.aop.dao.AccountDao;
import com.ozerutkualtun.aop.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        List<Account> accounts = null;

        try {
            // adding a boolean flag to simulate exceptions
            accounts = accountDao.findAccounts(true);
        } catch (Exception e) {
            System.out.println("Main program catch an exception: " + e);
        }

        // displaying the accounts
        System.out.println("\n\nMain Program: AfterThrowingDemoApp\n-------");
        System.out.println(accounts);
        System.out.println("\n");

        context.close();

    }
}
