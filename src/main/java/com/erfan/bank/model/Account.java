package com.erfan.bank.model;

import com.erfan.bank.dto.TransactionDTO;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final int id;
    private final String name;
    private double balance;
    private final List<TransactionDTO> transactions = new ArrayList<>();

    public Account(int id, String name, double initialBalance) {
        this.id = id;
        this.name = name;
        this.balance = initialBalance;
    }

    // Getters and setters:

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }
}