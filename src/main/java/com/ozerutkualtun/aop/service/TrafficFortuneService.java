package com.ozerutkualtun.aop.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(Boolean tripWire) throws RuntimeException{

        if(tripWire) {
            throw new RuntimeException("Runtime exception thrown from getFortune() method.");
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Expect heavy traffic this morning";
    }

}
