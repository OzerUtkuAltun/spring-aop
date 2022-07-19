package com.ozerutkualtun.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    private String serviceCode;

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK -> ADDING AN ACCOUNT");
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}