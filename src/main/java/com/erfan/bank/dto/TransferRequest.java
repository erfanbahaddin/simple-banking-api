package com.erfan.bank.dto;

import jakarta.validation.constraints.Positive;

public class TransferRequest {
    // Must be valid positive account ID
    @Positive
    private int fromAccountId;

    // Must be valid positive account ID
    @Positive
    private int toAccountId;

    // Amount must be greater than 0
    @Positive
    private double amount;

    // Getters and setters:

    public int getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public int getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(int toAccountId) {
        this.toAccountId = toAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
