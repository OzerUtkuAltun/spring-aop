package com.ozerutkualtun.aop.dao;

import com.ozerutkualtun.aop.model.Account;
import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

    public void addAccount(Account account, boolean vip) {

        System.out.println(getClass() + ": DOING MY DB WORK -> ADDING AN ACCOUNT");
    }
}
