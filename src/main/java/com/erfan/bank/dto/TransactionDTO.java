package com.erfan.bank.dto;

public class TransactionDTO {
    private Integer fromAccountId;
    private Integer toAccountId;
    private double amount;

    public TransactionDTO(Integer from, Integer to, double amount) {
        this.fromAccountId = from;
        this.toAccountId = to;
        this.amount = amount;
    }

    // Getters and setters:

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
