package com.ozerutkualtun.aop;

import com.ozerutkualtun.aop.config.DemoConfig;
import com.ozerutkualtun.aop.dao.AccountDao;
import com.ozerutkualtun.aop.model.Account;
import com.ozerutkualtun.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: AroundDemoApp");

        System.out.println(trafficFortuneService.getFortune());

        context.close();

    }
}
