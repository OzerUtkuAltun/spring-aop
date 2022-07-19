package com.ozerutkualtun.aop.dao;

import com.ozerutkualtun.aop.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {

    private String serviceCode;

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK -> ADDING AN ACCOUNT");
    }

    public List<Account> findAccounts(boolean tripWire) throws RuntimeException {

        if(tripWire) {
            throw new RuntimeException("Exception thrown by AccountDao");
        }

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Account1", "account1@mail.com"));
        accounts.add(new Account("Account2", "account2@mail.com"));
        accounts.add(new Account("Account3", "account3@mail.com"));
        accounts.add(new Account("Account4", "account4@mail.com"));

        return accounts;
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