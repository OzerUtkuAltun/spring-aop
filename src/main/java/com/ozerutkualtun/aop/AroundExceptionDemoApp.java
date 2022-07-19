package com.ozerutkualtun.aop;

import com.ozerutkualtun.aop.config.DemoConfig;
import com.ozerutkualtun.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundExceptionDemoApp {

    private static Logger logger = Logger.getLogger(AroundExceptionDemoApp.class.getName());

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("\nMain Program: AroundDemoApp");

        logger.info(trafficFortuneService.getFortune(true));

        logger.info("Finished!");

        context.close();

    }
}
