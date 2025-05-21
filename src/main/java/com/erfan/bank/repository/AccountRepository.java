package com.erfan.bank.repository;

import com.erfan.bank.model.Account;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccountRepository {
    private final Map<Integer, Account> accounts = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    // Save a new account
    public Account save(String name, double initialBalance) {
        int id = idCounter.getAndIncrement();
        Account account = new Account(id, name, initialBalance);
        accounts.put(id, account);
        return account;
    }

    // Find account by ID
    public Account findById(int id) {
        return accounts.get(id);
    }
}
