package com.ozerutkualtun.aop;

import com.ozerutkualtun.aop.config.DemoConfig;
import com.ozerutkualtun.aop.dao.AccountDao;
import com.ozerutkualtun.aop.dao.MembershipDao;
import com.ozerutkualtun.aop.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);

        accountDao.addAccount();

        membershipDao.addAccount(new Account(), true);

        context.close();
    }
}
