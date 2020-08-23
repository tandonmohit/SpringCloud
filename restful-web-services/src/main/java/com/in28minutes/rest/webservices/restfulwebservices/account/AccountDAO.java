package com.in28minutes.rest.webservices.restfulwebservices.account;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private static List<Account> accounts = new ArrayList<>();
    private static int counter=2;

    static {
        accounts.add(new Account(1,"Savings","Mohit"));
        accounts.add(new Account(2,"Current","Mohit"));
    }

    public List<Account> findAll() {
        return accounts;
    }

    public Account save(Account account) {
        account.setId(++counter);
        accounts.add(account);
        return account;
    }

    public Account findOne(Integer id) {
        for (Account account: accounts) {
            if (account.getId() == id)
                return account;
        }
        return null;
    }

}
